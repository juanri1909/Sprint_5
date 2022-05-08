package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service;

import java.util.List;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Tirada;


public interface TiradaService {
	public List<Tirada> Listar();
	public void Guardar(Tirada t);
	public void Borrar(Tirada t);
	public Tirada buscarTirada(int idpartida);
	
	public int Incrementador(List<Tirada> l);
}
