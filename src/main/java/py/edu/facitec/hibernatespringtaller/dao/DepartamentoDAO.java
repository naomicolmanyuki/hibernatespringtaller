package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.hibernatespringtaller.model.Departamento;

@Repository
public class DepartamentoDAO extends DaoGenerico<Departamento> {
	
	@PersistenceContext
	private EntityManager manager;
	
	public DepartamentoDAO() {
		super(Departamento.class);
	}


	@Override
	protected EntityManager getEntityManager() {
		return manager;
	}
	
}
