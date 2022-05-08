package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Jugador")
public class Jugador {
	
	@Id
	
	private int id_Jugador;
	
	private String nomJugador;
	
	private String fechaRegistro;

	public int getId_Jugador() {
		return id_Jugador;
	}
	
	public Jugador() {}
	
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
