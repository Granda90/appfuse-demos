package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.model.GameField;
import org.appfuse.tutorial.dao.GameFieldDao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("gameFieldDao")
public class GameFieldDaoHibernate extends GenericDaoHibernate<GameField, Long> implements GameFieldDao {

    public GameFieldDaoHibernate() {
        super(GameField.class);
    }

	public List<GameField> findByPhone(String phone) {
        return getSession().createCriteria(GameField.class).add(Restrictions.eq("phone", phone)).list();
	}

	public List<GameField> findByContact(String contact) {
        return getSession().createCriteria(GameField.class).add(Restrictions.eq("contact", contact)).list();

	}


}