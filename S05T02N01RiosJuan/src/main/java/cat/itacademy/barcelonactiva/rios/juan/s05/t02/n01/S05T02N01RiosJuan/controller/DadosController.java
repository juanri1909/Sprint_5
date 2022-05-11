package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Jugador;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Partida;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Tirada;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.dto.Dto;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service.JugadorService;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service.PartidaService;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service.TiradaService;



@RestController
public class DadosController {
	
	@Autowired
	private JugadorService jugadorservice;
	@Autowired
	private PartidaService partidaservice;
	@Autowired
	private TiradaService tiradaservice;
	
	 
	@PostMapping("/players")
	public ResponseEntity<?> insertar(@RequestBody Jugador j) {
		String respuesta="";
		
		if(j.getNomJugador()=="") {
			j=jugadorservice.nuevo(j.getNomJugador());
		}
		else {
			boolean existe = jugadorservice.ExisteJugador(j.getNomJugador());
			if(!existe) 
			{
				respuesta= "No se puede guardar exite el nombre de ";
				return new ResponseEntity<String>(respuesta+" "+j.getNomJugador(),HttpStatus.BAD_REQUEST);

			}
			else {
				j=jugadorservice.nuevo(j.getNomJugador());
			}
		}
		jugadorservice.Guardar(j);
		return new ResponseEntity<Jugador>(j,HttpStatus.CREATED);

		
	}
	
	@PutMapping("/player")
	public ResponseEntity<?> update(@RequestBody Jugador j) {
		String respuesta="";
		Optional<Jugador> j1;
		boolean existe = false;
		
		j1=jugadorservice.buscarJugador(j.getId_Jugador());
		if(j1==null) return new ResponseEntity<String>("No existe ese Jugador",HttpStatus.BAD_REQUEST);
		
		existe = jugadorservice.ExisteJugador(j.getNomJugador());
		
		if(!existe) 
		{
			respuesta= "No se puede guardar exite ese nombre";
		}
		else {
			j1=jugadorservice.buscarJugador(j.getId_Jugador());
			j.setFechaRegistro(j1.get().getFechaRegistro());
			jugadorservice.Guardar(j);
			return new ResponseEntity<Jugador>(j,HttpStatus.CREATED);
		}	
		return new ResponseEntity<String>(respuesta,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/players/{id}/games")
	public ResponseEntity<?> jugar(@PathVariable("id") int id){
		Optional<Jugador> j;
		Tirada t = new Tirada();

		j=jugadorservice.buscarJugador(id);
		if(j==null) return new ResponseEntity<String>("NO EXISTE ESE JUGADOR",HttpStatus.BAD_REQUEST);
		
		
		t=tiradaservice.tirada(id);
		tiradaservice.Guardar(t);
		
		return new ResponseEntity<Tirada>(t,HttpStatus.CREATED);
				//"TIRADA REALIZADA "+ "Dado1: "+ dado1+ " "+ " Dado2: "+ dado2;
	}
	
	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<?> borrarTirada(@PathVariable("id") int id) {
		Optional<Jugador> j1;
		Tirada t= new Tirada();
		List<Tirada> lt = new ArrayList<Tirada>();
		j1=jugadorservice.buscarJugador(id);
		if(j1==null) return new ResponseEntity<String>("NO EXISTE ESE JUGADOR",HttpStatus.BAD_REQUEST);
		List<Partida> lp = new ArrayList<Partida>();
		lp = partidaservice.ListaPorIdJugador(id);
		
		for(int i=0; i<lp.size(); i++) {
			t=tiradaservice.buscarTirada(lp.get(i).getId_Partida());
			if(t!=null) {
				tiradaservice.Borrar(t);//Cambio
				lt.add(t);
			}
							
		}
		return new ResponseEntity<List<Tirada>>(lt,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/players")
	//public List<Dto> porcentajeJugadores() {
	public ResponseEntity<List<Dto>> porcentajeJugadores() {
		List<Jugador> lj = new ArrayList<Jugador>();
		List<Dto> ldto = new ArrayList<Dto>();
		
		lj = jugadorservice.Listar();
		ldto = jugadorservice.porcentajes(lj);
		
		return new ResponseEntity<List<Dto>>(ldto,HttpStatus.CREATED);
		
		
	}
	
/*
 * GET /players/{id}/games: retorna el llistat de jugades per un jugador.
 *   	
 */
	@GetMapping("/players/{id}/games")
	public ResponseEntity<List<Tirada>> listarJugadas(@PathVariable("id") int id) {
		List<Tirada> respuesta = new ArrayList<Tirada>();
		List<Partida> lp = new ArrayList<Partida>();
		Tirada t = new Tirada();
		
		lp=partidaservice.ListaPorIdJugador(id);
		for(int i=0; i<lp.size();i++) {
			t=tiradaservice.buscarTirada(lp.get(i).getId_Partida());
			if(t!=null) respuesta.add(t);
		}
		return new ResponseEntity<List<Tirada>>(respuesta,HttpStatus.CREATED);
	}
	
	@GetMapping("/players/ranking")
	public ResponseEntity<List<Dto>> listarRanking(){
		List<Dto> ldto = new ArrayList<Dto>();
		List<Jugador> lj = new ArrayList<Jugador>();
		lj = jugadorservice.Listar();
	
		ldto = jugadorservice.porcentajes(lj);
		
		Collections.sort(ldto, new Comparator<Dto>() {
			@Override
			public int compare(Dto p1, Dto p2) {
				return  Float.compare(p2.getPorcentaje(), p1.getPorcentaje());
			}
		});
		return new ResponseEntity<List<Dto>>(ldto,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/players/ranking/lose")
	public ResponseEntity<?> peorJugador() {
		Dto peor = new Dto();
		List<Dto> ldto = new ArrayList<Dto>();
		List<Jugador> lj = new ArrayList<Jugador>();
		
		lj = jugadorservice.Listar();
		ldto = jugadorservice.porcentajes(lj);

		peor = ldto.get(0);	
		for(int i=0; i<ldto.size(); i++) {
			if (peor.getPorcentaje() > ldto.get(i).getPorcentaje()) {
				peor = ldto.get(i);
			}
		}
		
		return new ResponseEntity<Dto>(peor,HttpStatus.CREATED);
	}
	
	@GetMapping("/players/ranking/winer")
	public ResponseEntity<?> mejorJugador() {
		Dto mejor = new Dto();
		List<Dto> ldto = new ArrayList<Dto>();
		List<Jugador> lj = new ArrayList<Jugador>();
		
		lj = jugadorservice.Listar();
		ldto = jugadorservice.porcentajes(lj);
		mejor = ldto.get(0);	
		for(int i=0; i<ldto.size(); i++) {
			if (mejor.getPorcentaje() < ldto.get(i).getPorcentaje()) {
				mejor = ldto.get(i);
			}
		}
		
		return new ResponseEntity<Dto>(mejor,HttpStatus.CREATED);
	}
	
}
