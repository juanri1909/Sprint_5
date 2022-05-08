package cat.itacademy.barcelonactiva.rios.juan.s05.t022.S05T02N02RiosJuan.model.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Tirada")

public class Tirada {
	
	@Id
	private int idtirada;
	
	private int dado1;
	
	private int dado2;
	
	private int idpartida;
	
	public Tirada() {}

	public int getId_tirada() {
		return idtirada;
	}

	public void setId_tirada(int id_tirada) {
		this.idtirada = id_tirada;
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

	public int getIdpartida() {
		return idpartida;
	}

	public void setIdpartida(int idpartida) {
		this.idpartida = idpartida;
	}
	
	

}
