package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Tirada;

public interface TiradaRepositorio extends MongoRepository<Tirada, Integer>{
		Tirada findByidpartida(int idpartida);
}
