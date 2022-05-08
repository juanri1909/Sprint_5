package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Jugador;


public interface JugadorService {
	public void Guardar(Jugador j); 
	public boolean ExisteJugador(String nom);
	public Optional<Jugador> buscarJugador(int id);
	public List<Jugador> Listar();
	
	public int Incrementador(List<Jugador> l);
	
}
