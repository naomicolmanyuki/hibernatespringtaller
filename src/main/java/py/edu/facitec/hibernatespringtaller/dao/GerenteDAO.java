package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.hibernatespringtaller.model.Gerente;

@Repository
public class GerenteDAO extends DaoGenerico<Gerente> {

	@PersistenceContext
	private EntityManager manager;
	
	public GerenteDAO() {
		super(Gerente.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

	
}
