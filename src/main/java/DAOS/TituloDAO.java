package DAOS;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import models.Titulo;

@Stateless
public class TituloDAO {
	
	private EntityManager em;
	
	public boolean insertJPA(Titulo entity) {
		em.persist(entity);
		return true;
	}
	
	public List<Titulo> listar() {
		String jpql = "select t from Titulo t";
		List<Titulo> titulos = em.createQuery(jpql, Titulo.class).getResultList();
		return titulos;
	}
	
}
