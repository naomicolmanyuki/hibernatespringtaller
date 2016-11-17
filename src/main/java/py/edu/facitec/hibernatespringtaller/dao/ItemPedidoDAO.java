package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.hibernatespringtaller.model.ItemPedido;

@Repository
public class ItemPedidoDAO extends DaoGenerico<ItemPedido> {

	@PersistenceContext
	private EntityManager manager;
	
	public ItemPedidoDAO() {
		super(ItemPedido.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}

	
}
