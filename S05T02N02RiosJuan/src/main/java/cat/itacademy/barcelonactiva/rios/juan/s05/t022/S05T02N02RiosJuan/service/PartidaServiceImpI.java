package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Partida;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.repository.PartidaRepositorio;

@Service
public class PartidaServiceImpI implements PartidaService{
	
	
	@Autowired
	private PartidaRepositorio partidarepositorio;

	@Override
	public List<Partida> Listar() {
		// TODO Apéndice de método generado automáticamente
		return (List<Partida>) partidarepositorio.findAll();
	}

	@Override
	public void guardar(Partida p) {
		partidarepositorio.save(p);
		
	}

	@Override
	public List<Partida> ListaPorIdJugador(int id) {
		return (List<Partida>) partidarepositorio.findByidjugador(id);
	}
	
	public int Incrementador(List<Partida> l) {
		List<Integer> milista = new ArrayList<>();
		for(int i=0; i<l.size(); i++) {
			milista.add(l.get(i).getId_Partida());
		}
		for(int i=1; i<=l.size()+1;i++) {
			if(!milista.contains(i)) {
				return i;
			}			
		}
		return 0;
	}

	

}
