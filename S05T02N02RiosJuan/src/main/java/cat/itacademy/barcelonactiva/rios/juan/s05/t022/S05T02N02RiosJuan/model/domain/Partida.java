package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Partida")
public class Partida {
	@Id
	private int id_Partida;
	private int idjugador;
	
	public Partida() {
		
	}

	public int getId_Partida() {
		return id_Partida;
	}

	public void setId_Partida(int id_Partida) {
		this.id_Partida = id_Partida;
	}

	public int getIdjugador() {
		return idjugador;
	}

	public void setIdjugador(int idjugador) {
		this.idjugador = idjugador;
	}
	
	

}
