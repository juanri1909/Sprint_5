package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service;

import java.util.List;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Partida;


public interface PartidaService {
	public List<Partida> Listar();
	public void guardar(Partida p);
	public List<Partida> ListaPorIdJugador(int id);
	
	public int Incrementador(List<Partida> l);
	
	
}
