package cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.dto;


import java.util.List;

import cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.domain.Sucursal;



public class SucursalDTO {
	
	private int pk_SucursalId;

	private String nomSucursal;

	private String paisSucursal;
	
	private String tipusSucursal;
	
	private static final List<String> paises = List.of("España","Francia","Italia");
	
	public SucursalDTO(Sucursal s) {
		
		this.pk_SucursalId = s.getPk_SucursalId();
		this.nomSucursal = s.getNomSucursal();
		this.paisSucursal = s.getPaisSucursal();
		this.tipusSucursal = "NO UE";
		for(int i=0; i<paises.size(); i++) {
			if(paises.get(i).equals(s.getPaisSucursal())) {
				this.tipusSucursal = "UE";
			}
		}
		
	}
	
	public SucursalDTO() {}

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

	public static List<String> getPaises() {
		return paises;
	}

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}
	
	

}
