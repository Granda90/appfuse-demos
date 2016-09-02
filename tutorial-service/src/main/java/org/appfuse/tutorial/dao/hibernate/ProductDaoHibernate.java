package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.ProductDao;
import org.appfuse.tutorial.model.Product;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {

    public ProductDaoHibernate() {
        super(Product.class);
    }
	
	@Override
	public List<Product> findByName(String name) {
        return getSession().createCriteria(Product.class).add(Restrictions.eq("name", name)).list();
	}

}
