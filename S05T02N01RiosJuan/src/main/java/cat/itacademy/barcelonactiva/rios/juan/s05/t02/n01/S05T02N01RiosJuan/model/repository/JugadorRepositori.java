package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Jugador;


public interface JugadorRepositori  extends CrudRepository<Jugador, Integer>{
	
	Optional<Jugador> findBynomJugador(String nom);
	
}
