package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Jugador;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Partida;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Tirada;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.dto.Dto;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service.JugadorService;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service.PartidaService;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service.TiradaService;


@RestController
public class DadosController {
	
	@Autowired
	private JugadorService jugadorservice;
	@Autowired
	private PartidaService partidaservice;
	@Autowired
	private TiradaService tiradaservice;
	
	 
	@PostMapping("/players")
	public String insertar(@RequestBody Jugador j) {
		String respuesta="";
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		List<Jugador>lj = new ArrayList<Jugador>();
		lj=jugadorservice.Listar();
		if(j.getNomJugador()=="") {
			j.setId_Jugador(jugadorservice.Incrementador(lj));//Cambio			
			j.setNomJugador("ANONIMO");
			j.setFechaRegistro(timeStamp);
			jugadorservice.Guardar(j);
			return "exito";
		}
		else {
			boolean existe = jugadorservice.ExisteJugador(j.getNomJugador());
			if(!existe) 
			{
				respuesta= "No se puede guardar exite ese nombre";
			}
			else {
				System.out.println("Exito. se puede guardar" + timeStamp);
				j.setId_Jugador(jugadorservice.Incrementador(lj));//cambio
				j.setFechaRegistro(timeStamp);
				jugadorservice.Guardar(j);
			}			
		}
		return respuesta;
	}
	
	@PutMapping("/player")
	public String update(@RequestBody Jugador j) {
		String respuesta="";
		Optional<Jugador> j1;
		boolean existe = false;
		
		j1=jugadorservice.buscarJugador(j.getId_Jugador());
		if(j1==null) return "NO EXISTE ESE JUGADOR";
		
		existe = jugadorservice.ExisteJugador(j.getNomJugador());
		
		if(!existe) 
		{
			respuesta= "No se puede guardar exite ese nombre";
		}
		else {
			j1=jugadorservice.buscarJugador(j.getId_Jugador());
			j.setFechaRegistro(j1.get().getFechaRegistro());
			jugadorservice.Guardar(j);
		}	
		return respuesta;
	}
	
	@PostMapping("/players/{id}/games")
	public String jugar(@PathVariable("id") int id){
		Optional<Jugador> j;
		j=jugadorservice.buscarJugador(id);
		if(j==null) return "NO EXISTE ESE JUGADOR";
		
		Partida p = new Partida();
		List<Partida> lp = new ArrayList<Partida>();
		lp=partidaservice.Listar();
		
		p.setId_Partida(partidaservice.Incrementador(lp));//Cambio
		p.setIdjugador(id);
		partidaservice.guardar(p);
		
		int dado1=(int) Math.floor(Math.random()*6+1);
		int dado2=(int) Math.floor(Math.random()*6+1);
		Tirada t = new Tirada();
		List<Tirada> lt = new ArrayList<Tirada>();
		lt=tiradaservice.Listar();
		
		t.setId_tirada(tiradaservice.Incrementador(lt));//Cambio
		t.setDado1(dado1);
		t.setDado2(dado2);
		t.setIdpartida(p.getId_Partida());
		tiradaservice.Guardar(t);
		
		return "TIRADA REALIZADA "+ "Dado1: "+ dado1+ " "+ " Dado2: "+ dado2;
	}
	
	@DeleteMapping("/players/{id}/games")
	public String borrarTirada(@PathVariable("id") int id) {
		Optional<Jugador> j1;
		Tirada t;
		j1=jugadorservice.buscarJugador(id);
		if(j1==null) return "NO EXISTE ESE JUGADOR";
		List<Partida> lp = new ArrayList<Partida>();
		lp = partidaservice.ListaPorIdJugador(id);
		
		for(int i=0; i<lp.size(); i++) {
			t=tiradaservice.buscarTirada(lp.get(i).getId_Partida());
			if(t!=null) {
				tiradaservice.Borrar(t);//Cambio
			}
							
		}
		return "BORRADA LAS TIRADAS";
		
	}
	
	/*
	 * GET /players/: retorna el llistat de tots  els jugadors del sistema
	 *   amb el seu  percentatge mig  d’èxits   
	 * 
	 */
	@GetMapping("/players")
	public List<Dto> porcentajeJugadores() {
		float exito=0;
		float contador=0;
		List<Jugador> lj = new ArrayList<Jugador>();
		List<Partida> lp = new ArrayList<Partida>();
		List<Dto> ldto = new ArrayList<Dto>();
		Dto dto = new Dto();
		Tirada t=new Tirada();
		
		lj = jugadorservice.Listar();
		for(int i=0; i<lj.size();i++) {
			lp=partidaservice.ListaPorIdJugador(lj.get(i).getId_Jugador());
			for(int j=0; j<lp.size(); j++) {
				t=tiradaservice.buscarTirada(lp.get(j).getId_Partida());
				if(t!=null) {
					contador = contador + 1;
					if(t.getDado1()+t.getDado2()==7) {
						exito = exito + 1;
					}
				}
			}
			dto.setIdJugador(lj.get(i).getId_Jugador());
			dto.setNombreJugador(lj.get(i).getNomJugador());
			if(exito == 0) {
				dto.setPorcentaje(0);
			}
			else {
				
				dto.setPorcentaje(exito/contador);
			}
			
			ldto.add(dto);
			exito=0;
			contador=0;
			dto = new Dto();			 		
		}
		List<String> respuesta = new ArrayList<String>();
		for(int i=0; i<ldto.size(); i++) {
			respuesta.add("Nombre: "+ ldto.get(i).getNombreJugador()+" "+"Porcentaje: " +ldto.get(i).getPorcentaje()+" %");
		}
				
		return ldto;
		
		
	}
	
/*
 * GET /players/{id}/games: retorna el llistat de jugades per un jugador.
 *   	
 */
	@GetMapping("/players/{id}/games")
	public List<Tirada> listarJugadas(@PathVariable("id") int id) {
		List<Tirada> respuesta = new ArrayList<Tirada>();
		List<Partida> lp = new ArrayList<Partida>();
		Tirada t = new Tirada();
		
		lp=partidaservice.ListaPorIdJugador(id);
		for(int i=0; i<lp.size();i++) {
			t=tiradaservice.buscarTirada(lp.get(i).getId_Partida());
			if(t!=null) respuesta.add(t);
		}
		return respuesta;
	}
	
	@GetMapping("/players/ranking")
	public List<Dto> listarRanking(){
		List<Dto> ldto = new ArrayList<Dto>();
		
		ldto = porcentajeJugadores();
		
		Collections.sort(ldto, new Comparator<Dto>() {
			@Override
			public int compare(Dto p1, Dto p2) {
				return  Float.compare(p2.getPorcentaje(), p1.getPorcentaje());
			}
		});
		return ldto;
	}
	
	@GetMapping("/players/ranking/lose")
	public Dto peorJugador() {
		Dto peor = new Dto();
		List<Dto> ldto = new ArrayList<Dto>();
		
		ldto = porcentajeJugadores();
		peor = ldto.get(0);	
		for(int i=0; i<ldto.size(); i++) {
			if (peor.getPorcentaje() > ldto.get(i).getPorcentaje()) {
				peor = ldto.get(i);
			}
		}
		
		return peor;
	}
	
	@GetMapping("/players/ranking/winer")
	public Dto mejorJugador() {
		Dto mejor = new Dto();
		List<Dto> ldto = new ArrayList<Dto>();
		
		ldto = porcentajeJugadores();
		mejor = ldto.get(0);	
		for(int i=0; i<ldto.size(); i++) {
			if (mejor.getPorcentaje() < ldto.get(i).getPorcentaje()) {
				mejor = ldto.get(i);
			}
		}
		
		return mejor;
	}
	
}
