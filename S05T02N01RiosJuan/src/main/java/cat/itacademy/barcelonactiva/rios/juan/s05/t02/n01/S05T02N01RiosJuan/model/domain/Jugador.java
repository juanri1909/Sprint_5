package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jugador {
	@Id
	private int id_Jugador;
	@Column(name = "nomJugador")
	private String nomJugador;
	@Column(name = "fechaRegistro")
	private String fechaRegistro;
	
	public Jugador(int id_Jugador, String nomJugador, String fechaRegistro) {
		this.id_Jugador = id_Jugador;
		this.nomJugador = nomJugador;
		this.fechaRegistro = fechaRegistro;
	}
	
	public Jugador() {}


	public int getId_Jugador() {
		return id_Jugador;
	}


	public void setId_Jugador(int id_Jugador) {
		this.id_Jugador = id_Jugador;
	}


	public String getNomJugador() {
		return nomJugador;
	}


	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}


	public String getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}



