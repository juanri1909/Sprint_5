package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service;

import java.util.List;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Partida;


public interface PartidaService {
	public List<Partida> Listar();
	public void guardar(Partida p);
	public List<Partida> ListaPorIdJugador(int id);
	
	public int Incrementador(List<Partida> l);
}
