package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Jugador;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.repository.JugadorRepositori;


@Service
public class JugadorServiceImpI implements JugadorService{
	
	@Autowired
	private JugadorRepositori jugadorrepositori;

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

	

}
