package org.appfuse.tutorial.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.GameField;

public interface GameFieldDao extends GenericDao<GameField, Long> {
	public List<GameField> findByPhone(String phone);

	public List<GameField> findByContact(String contact);
}
