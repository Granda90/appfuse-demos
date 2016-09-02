package org.appfuse.tutorial.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.appfuse.tutorial.dao.ProductDao;
import org.appfuse.tutorial.model.Company;
import org.appfuse.tutorial.model.Product;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ProductManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private ProductManagerImpl manager;

	@Mock
	private ProductDao dao;

	@Test
	public void testPriceWithTaxt() {
		// given
		final Long id = 1L;
		final Double price = new Double(1000);

		final Product product = new Product();
		final Company company = new Company();

		company.setTax(new Double(0.13));
		product.setPrice(price);
		product.setCompany(company);

		given(dao.get(id)).willReturn(product);

		// when
		Double resultPrice = manager.priceWithTax(id);

		// then

		assertTrue(resultPrice > 0);
		assertEquals(new Double(1130), resultPrice);
	}
	
	@Test
	public void testUpdateQuantity() {
		// given
		final Long id = 1L;
		final Double quantity = new Double(5);

		final Product product = new Product();

		product.setQuantity(quantity);

		given(dao.get(id)).willReturn(product);

		String messageOK = manager.updateQuantity(id, new Double(2));
		assertEquals(messageOK, "OK");
		
		String messageRefill = manager.updateQuantity(id, new Double(3));
		assertEquals(messageRefill, "REFILL");
		
		String messageError = manager.updateQuantity(id, new Double(1));
		assertEquals(messageError, "ERROR");
	}
}
