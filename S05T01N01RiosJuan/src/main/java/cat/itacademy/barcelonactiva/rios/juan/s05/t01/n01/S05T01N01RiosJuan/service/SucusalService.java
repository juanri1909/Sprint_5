package cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.service;

import java.util.List;
import java.util.Optional;
import cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.domain.Sucursal;

public interface SucusalService {
	
	public List<Sucursal> Listar();
	public void Guardar(Sucursal s);
	public void eliminar(int identif);
	public Optional<Sucursal> listarPorId(int identif);

}
