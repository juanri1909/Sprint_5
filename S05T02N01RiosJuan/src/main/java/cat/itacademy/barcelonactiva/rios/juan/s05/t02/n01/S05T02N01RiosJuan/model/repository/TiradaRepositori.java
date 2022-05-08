package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.repository;


import org.springframework.data.repository.CrudRepository;

import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain.Tirada;

public interface TiradaRepositori extends CrudRepository<Tirada, Integer>{
	Tirada findByidpartida(int idpartida);

}
