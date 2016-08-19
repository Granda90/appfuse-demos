package org.appfuse.tutorial.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.appfuse.tutorial.dao.GameFieldDao;
import org.appfuse.tutorial.model.GameField;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class GameFieldManagerImpTest extends BaseManagerMockTestCase {

	@InjectMocks
	private GameFieldManagerImpl manager;

	@Mock
	private GameFieldDao dao;

	@Test
	public void testPriceWithTaxt() {
		// given
		final Long id = 1L;
		final Double price = new Double(25000);

		final GameField gameField = new GameField();

		gameField.setPrice(price);

		given(dao.get(id)).willReturn(gameField);

		// when
		Double resultPrice = manager.priceWithTax(id);

		// then

		assertTrue(resultPrice > 0);
		assertEquals(new Double(28250), resultPrice);

	}
}
