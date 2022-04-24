package cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Sucursal {
	
	@Id
	private int pk_SucursalId;
	@Column(name = "nomSucursal")
	private String nomSucursal;
	@Column(name = "paisSucursal")
	private String paisSucursal;
	
	public Sucursal() {
		
	}
	
	public Sucursal(int pk_SucursalId, String nomSucursal, String paisSucursal) {
		this.pk_SucursalId = pk_SucursalId;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}
	
	public int getPk_SucursalId() {
		return pk_SucursalId;
	}
	public void setPk_SucursalId(int pk_SucursalId) {
		this.pk_SucursalId = pk_SucursalId;
	}
	public String getNomSucursal() {
		return nomSucursal;
	}
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public String getPaisSucursal() {
		return paisSucursal;
	}
	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}
	
	

}
