package DAOS;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import models.Persona;

@Stateless
public class PersonaDAO {
	
	private EntityManager em;
	
	public boolean insertJPA(Persona entity) {
		em.persist(entity);
		return true;
	}

	
	public Persona buscar(String cedula) {
		Persona x = new Persona();
		Persona p = em.createQuery(
				"SELECT p FROM Persona p WHERE p.cedula = '" + cedula + "'", Persona.class)
				.getSingleResult();
		return p;
	}
	
	public void actualizar(Persona p) {
		em.merge(p);
	}
}
