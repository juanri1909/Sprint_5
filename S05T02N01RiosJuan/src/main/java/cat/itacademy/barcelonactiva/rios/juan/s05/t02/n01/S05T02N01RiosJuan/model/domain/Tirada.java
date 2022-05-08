package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tirada {
	
	@Id
	private int id_tirada;
	@Column(name = "dado1")
	private int dado1;
	@Column(name = "dado2")
	private int dado2;
	@Column(name = "idpartida")
	private int idpartida;
	
	
	public Tirada(int id_tirada, int dado1, int dado2, int id_partida) {
		this.id_tirada = id_tirada;
		this.dado1 = dado1;
		this.dado2 = dado2;
		this.idpartida = id_partida;
	}
	
	
	
	public Tirada() {}

	public int getId_tirada() {
		return id_tirada;
	}

	public void setId_tirada(int id_tirada) {
		this.id_tirada = id_tirada;
	}

	public int getDado1() {
		return dado1;
	}

	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}

	public int getId_partida() {
		return idpartida;
	}

	public void setId_partida(int id_partida) {
		this.idpartida = id_partida;
	}
	
	
	
	
	
	

}
