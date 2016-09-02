package org.appfuse.tutorial.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class ProductDaoTest extends BaseDaoTestCase {
    @Autowired
    private ProductDao productDao;

    @Test
    public void testFindProductByName() throws Exception {
        List<Product> product = productDao.findByName("DSA");
        assertTrue(product.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveProduct() throws Exception {
        Product product = new Product();
        product.setName("DSA");
        product.setQuantity(new Double(5));

        product = productDao.save(product);
        flush();

        product = productDao.get(product.getProductId());

        assertEquals("DSA", product.getName());
        assertNotNull(product.getProductId());


        productDao.remove(product.getProductId());
        flush();

        // should throw DataAccessException
        productDao.get(product.getProductId());
    }
}