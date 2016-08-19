package org.appfuse.tutorial.service.impl;

import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.tutorial.dao.GameFieldDao;
import org.appfuse.tutorial.model.GameField;
import org.appfuse.tutorial.service.GameFieldManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("gameFieldManager")
public class GameFieldManagerImpl extends GenericManagerImpl<GameField, Long> implements GameFieldManager {

	GameFieldDao gameFieldDao;
	
	@Autowired
	public GameFieldManagerImpl(GameFieldDao gameFieldDao) {
		super(gameFieldDao);
		this.gameFieldDao = gameFieldDao;
	}

	@Override
	public Double priceWithTax(Long id) {
		Double tax = new Double(0);
		Double price = new Double(0);
		
		GameField gameField = gameFieldDao.get(id);
		
		if (gameField != null) {
			tax = gameField.getPrice() * 0.13;
			price = gameField.getPrice() + tax; 
		}
		
		return price;
	}
	
}
