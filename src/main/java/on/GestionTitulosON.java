package on;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import DAOS.PersonaDAO;
import DAOS.TituloDAO;
import models.Persona;
import models.Titulo;

@Stateless
public class GestionTitulosON implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonaDAO perDAO;
	
	@Inject
	private TituloDAO tituloDAO;
	
	public boolean validarPersona(String cedula) {
		Persona x = perDAO.buscar(cedula); 
		if (x != null) {
			return true;
		}else {
			return false;
		}	
	}
	
	public String registrarTitulo(Titulo t, String cedula){		
		if (validarPersona(cedula) == true) {			
			if (cedula.length() != 10 ) {
				t.setCodigoAlfanumerico(generarCodigo());
				tituloDAO.insertJPA(t);
				Persona x = perDAO.buscar(cedula);
				x.addTitulo(t);
				perDAO.actualizar(x);
				return "Titulo registrado exitosamente a nombre de: "+x.getNombre() + " "+x.getApellido() +" con codigo: "+ t.getCodigoAlfanumerico();
			}else {
				return "Cedula Incompleta";
			}
		}else {
			return "Registro no existe en el sistema";
		}	
	}
	
	public List<Titulo> buscarTitulosPorPersona(String cedula){
		return tituloDAO.listar();
	}
	
	public String generarCodigo() {
		
		String caracteres = "0123456789"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz";
		String password = "";
		for (int i = 0; i < 9; i++) {
			password += (caracteres.charAt((int)(Math.random() * caracteres.length())));
		}	
		return password;
	}

}
