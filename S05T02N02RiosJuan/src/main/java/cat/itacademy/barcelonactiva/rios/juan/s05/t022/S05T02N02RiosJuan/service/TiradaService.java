package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service;

import java.util.List;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Tirada;


public interface TiradaService {
	public List<Tirada> Listar();
	public void Guardar(Tirada t);
	public void Borrar(Tirada t);
	//public List<Tirada> listarTirada(int idpartida);
	public Tirada buscarTirada(int idpartida);
	
	public int Incrementador(List<Tirada> l);

}
