package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.hibernatespringtaller.model.Usuario;

@Repository
public class UsuarioDAO extends DaoGenerico<Usuario>{

	@PersistenceContext
	private EntityManager manager;
	
	public UsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
}
