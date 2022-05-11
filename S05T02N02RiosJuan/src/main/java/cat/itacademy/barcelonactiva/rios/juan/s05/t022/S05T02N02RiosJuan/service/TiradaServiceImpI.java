package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Partida;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Tirada;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.repository.TiradaRepositorio;

@Service
public class TiradaServiceImpI implements TiradaService{
	@Autowired
	private TiradaRepositorio tiradarepositorio;
	@Autowired
	private PartidaService partidaservice;
	
	
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

	@Override
	public Tirada tirada(int idJugador) {
		Partida p = new Partida();
		List<Partida> lp = new ArrayList<Partida>();
		lp=partidaservice.Listar();
		
		p.setId_Partida(partidaservice.Incrementador(lp));//Cambio
		p.setIdjugador(idJugador);
		partidaservice.guardar(p);
		
		int dado1=(int) Math.floor(Math.random()*6+1);
		int dado2=(int) Math.floor(Math.random()*6+1);
		Tirada t = new Tirada();
		List<Tirada> lt = new ArrayList<Tirada>();
		lt=Listar();
		
		t.setId_tirada(Incrementador(lt));//Cambio
		t.setDado1(dado1);
		t.setDado2(dado2);
		t.setIdpartida(p.getId_Partida());
		
		return t;
	}

	
}
