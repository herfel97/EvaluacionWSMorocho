package services;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import models.Titulo;
import on.GestionTitulosON;

@WebService
public class ClienteServiceSOAP {
	
	@Inject
	private GestionTitulosON gestion;
	
	@WebMethod
	public String registroTitulo(String cedula, String nombreTitulo, String universidad) {
		Titulo t = new Titulo();
		t.setNombreTitulo(nombreTitulo);
		t.setUniversidad(universidad);
		return gestion.registrarTitulo(t,cedula);		
	}
}
