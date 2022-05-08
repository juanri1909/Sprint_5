package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Partida;

public interface PatidaRepositori extends CrudRepository<Partida, Integer>{
	 List<Partida> findByidjugador(int idjugador);

}
