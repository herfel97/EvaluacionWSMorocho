package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Persona")
@Entity
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String cedula;
	
	private String nombre;
	private String apellido;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Titulo> listaTitulos;
	
	public Persona () {
		listaTitulos = new ArrayList<Titulo>();
	}
		
	public List<Titulo> getListaTitulos() {
		return listaTitulos;
	}
	public void setListaTitulos(List<Titulo> listaTitulos) {
		this.listaTitulos = listaTitulos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void addTitulo(Titulo t) {
		listaTitulos.add(t);
	}

}
