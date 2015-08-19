package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.ComidaDao;
import org.appfuse.tutorial.model.Comida;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("menuDao")
public class ComidaDaoHibernate extends GenericDaoHibernate<Comida, Long>implements ComidaDao {

	public ComidaDaoHibernate() {
		super(Comida.class);
	}

	@Override
	public List<Comida> findByTipo(String tipo) {
		return getSession().createCriteria(Comida.class).add(Restrictions.eq("tipo", tipo)).list();

	}

}
