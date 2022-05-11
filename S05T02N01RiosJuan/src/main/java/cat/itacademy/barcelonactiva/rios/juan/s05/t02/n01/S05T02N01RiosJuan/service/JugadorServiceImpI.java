package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Jugador;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Partida;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Tirada;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.dto.Dto;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.repository.JugadorRepositori;


@Service
public class JugadorServiceImpI implements JugadorService{
	
	@Autowired
	private JugadorRepositori jugadorrepositori;
	@Autowired
	private PartidaService partidaservice;
	@Autowired
	private TiradaService tiradaservice;

	@Override
	public void Guardar(Jugador j) {
		jugadorrepositori.save(j);
		
	}
	
	@Override
	public boolean ExisteJugador(String nom) {
		Optional<Jugador> j;
		j=jugadorrepositori.findBynomJugador(nom);
		if(!j.isEmpty()) 
		{
			return false;
		}
		return true;
		
	}

	@Override
	public Optional<Jugador> buscarJugador(int id) {
		Optional<Jugador> j;
		j=jugadorrepositori.findById(id);
		if(!j.isEmpty()) 
		{
			return j;
		}
	return null;
	}

	@Override
	public List<Jugador> Listar() {
		return (List<Jugador>) jugadorrepositori.findAll();
	}
	
	public int Incrementador(List<Jugador> l) {
		List<Integer> milista = new ArrayList<>();
		for(int i=0; i<l.size(); i++) {
			milista.add(l.get(i).getId_Jugador());
		}
		for(int i=1; i<=l.size()+1;i++) {
			if(!milista.contains(i)) {
				return i;
			}			
		}
		return 0;
	}

	@Override
	public List<Dto> porcentajes(List<Jugador> lj) {
		float exito=0;
		float contador=0;
		List<Partida> lp = new ArrayList<Partida>();
		List<Dto> ldto = new ArrayList<Dto>();
		Dto dto = new Dto();
		Tirada t=new Tirada();
		
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
		

		return ldto;
	}

	@Override
	public Jugador nuevo(String nombre) {
		Jugador j = new Jugador();
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		List<Jugador>lj = new ArrayList<Jugador>();
		lj=Listar();
		if(nombre == "") {					
			j.setNomJugador("ANONIMO");
		}
		else {				
			j.setNomJugador(nombre);
		}
		j.setId_Jugador(Incrementador(lj));//Cambio	
		j.setFechaRegistro(timeStamp);
		
		return j;
	}


	

}
