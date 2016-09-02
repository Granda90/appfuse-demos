package org.appfuse.tutorial.service.impl;

import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.tutorial.dao.ProductDao;
import org.appfuse.tutorial.model.Product;
import org.appfuse.tutorial.service.ProductManager;

public class ProductManagerImpl extends GenericManagerImpl<Product, Long> implements ProductManager {
	ProductDao productDao;

	public ProductManagerImpl() {
	}

	public ProductManagerImpl(ProductDao productDao) {
		super(productDao);
		this.productDao = productDao;
	}

	@Override
	public Double priceWithTax(Long id) {
		Double price = new Double(0);
		Double tax = new Double(0);

		Product product = productDao.get(id);

		if (product != null) {
			tax = product.getPrice() * product.getCompany().getTax();
			price = product.getPrice() + tax;
		}
		return price;
	}

	@Override
	public String updateQuantity(Long id, Double quantity) {
		String message = "OK";
		Double realQuantity = new Double(0);

		Product product = productDao.get(id);

		if (product != null) {
			realQuantity = product.getQuantity() - quantity;

			if (realQuantity < 0) {
				message = "ERROR";
			} else {
				product.setQuantity(realQuantity);
				productDao.save(product);
				
				if (realQuantity < 2) {
					message = "REFILL";
				}
			}
		}

		return message;
	}

}
