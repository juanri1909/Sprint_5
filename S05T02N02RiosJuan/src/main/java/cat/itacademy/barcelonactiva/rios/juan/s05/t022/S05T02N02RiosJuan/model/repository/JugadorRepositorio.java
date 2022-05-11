package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain.Jugador;

public interface JugadorRepositorio extends MongoRepository <Jugador, Integer> {
	Optional<Jugador> findBynomJugador(String nom);
}
