package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Tirada;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.repository.TiradaRepositori;

@Service
public class TiradaServiceImpI implements TiradaService{
	@Autowired
	private TiradaRepositori tiradarepositorio;
	
	
	@Override
	public List<Tirada> Listar() {
		// TODO Apéndice de método generado automáticamente
		return (List<Tirada>) tiradarepositorio.findAll();
	}

	@Override
	public void Guardar(Tirada t) {
		tiradarepositorio.save(t);		
	}

	@Override
	public void Borrar(Tirada t) {
		tiradarepositorio.delete(t);
		
	}

	@Override
	public Tirada buscarTirada(int idpartida) {
		// TODO Apéndice de método generado automáticamente
		return tiradarepositorio.findByidpartida(idpartida);
	}
	
	public int Incrementador(List<Tirada> l) {
		List<Integer> milista = new ArrayList<>();
		for(int i=0; i<l.size(); i++) {
			milista.add(l.get(i).getId_tirada());
		}
		for(int i=1; i<=l.size()+1;i++) {
			if(!milista.contains(i)) {
				return i;
			}			
		}
		return 0;
	}


}
