package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Partida;

public interface PartidaRepositorio extends MongoRepository<Partida, Integer>{
	List<Partida> findByidjugador(int idjugador);
}
