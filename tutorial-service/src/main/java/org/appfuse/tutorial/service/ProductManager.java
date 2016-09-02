package org.appfuse.tutorial.service;

import org.appfuse.service.GenericManager;
import org.appfuse.tutorial.model.Product;

public interface ProductManager extends GenericManager<Product, Long> {

	Double priceWithTax(Long id);
	
	String updateQuantity(Long id, Double quantity);
}
