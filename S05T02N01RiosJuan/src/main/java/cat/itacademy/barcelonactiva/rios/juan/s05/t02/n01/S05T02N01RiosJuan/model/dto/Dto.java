package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.model.dto;

public class Dto {
	private int idJugador;
	private String nombreJugador;
	//private String nuevoNombreJugador;
	//private int idPartida;
	//private int idTirada;
	//private int dado1;
	//private int dado2;
	private float porcentaje;
	//private boolean resultado;
	
	public Dto() {}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

/*	public String getNuevoNombreJugador() {
		return nuevoNombreJugador;
	}

	public void setNuevoNombreJugador(String nuevoNombreJugador) {
		this.nuevoNombreJugador = nuevoNombreJugador;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}

	public int getIdTirada() {
		return idTirada;
	}

	public void setIdTirada(int idTirada) {
		this.idTirada = idTirada;
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
*/
	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
/*
	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	
*/	

}
