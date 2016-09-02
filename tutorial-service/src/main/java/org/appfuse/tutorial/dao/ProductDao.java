package org.appfuse.tutorial.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Product;

public interface ProductDao extends GenericDao<Product, Long> {
	public List<Product> findByName(String name);
}
