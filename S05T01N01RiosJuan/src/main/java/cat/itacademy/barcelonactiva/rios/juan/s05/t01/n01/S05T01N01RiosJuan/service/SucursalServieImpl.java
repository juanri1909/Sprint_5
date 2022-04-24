package cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.repository.SucursalRepositori;

@Service
public class SucursalServieImpl implements SucusalService{
	@Autowired
	private SucursalRepositori sucursalrepositori;

	@Override
	public List<Sucursal> Listar() {
		 return (List<Sucursal>) sucursalrepositori.findAll();

	}

	@Override
	public void Guardar(Sucursal s) {
		sucursalrepositori.save(s);
	}

	
	@Override
	public void eliminar(int identif) {
		 sucursalrepositori.deleteById(identif);
		
	}

	@Override
	public Optional<Sucursal> listarPorId(int identif) {
		// TODO Apéndice de método generado automáticamente
		return sucursalrepositori.findById(identif);
	} 

}
