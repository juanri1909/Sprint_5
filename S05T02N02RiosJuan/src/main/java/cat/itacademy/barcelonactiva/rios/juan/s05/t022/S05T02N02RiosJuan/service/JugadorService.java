package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Jugador;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Partida;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Tirada;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.dto.Dto;

public interface JugadorService {
	public void Guardar(Jugador j); 
	public boolean ExisteJugador(String nom);
	public Optional<Jugador> buscarJugador(int id);
	public List<Jugador> Listar();
	
	public int Incrementador(List<Jugador> l);
	public List<Dto> porcentajes(List<Jugador> lj);
	public Jugador nuevo(String nombre);

}
