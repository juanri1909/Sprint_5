package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partida {
	
	@Id
	private int id_Partida;
	@Column(name = "idjugador")
	private int idjugador;
		
	public Partida(int id_Partida,int id_j) {
		this.id_Partida = id_Partida;
		this.idjugador = id_j;
	}
	
	public Partida() {}
	

	public int getId_Partida() {
		return id_Partida;
	}

	public void setId_Partida(int id_Partida) {
		this.id_Partida = id_Partida;
	}	

	public int getId_jugador() {
		return idjugador;
	}

	public void setId_jugador(int id_jugador) {
		this.idjugador = id_jugador;
	}
	
	
	
	

	
	
	
	

}
