package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "titulo")
@Entity
public class Titulo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String codigoAlfanumerico;
	private String nombreTitulo;
	private String universidad;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoAlfanumerico() {
		return codigoAlfanumerico;
	}
	public void setCodigoAlfanumerico(String codigoAlfanumerico) {
		this.codigoAlfanumerico = codigoAlfanumerico;
	}
	public String getNombreTitulo() {
		return nombreTitulo;
	}
	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}	
	
}
