package org.appfuse.tutorial.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.Comida;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ComidaDaoTest extends BaseDaoTestCase {
	@Autowired
	private ComidaDao comidaDao;

	@Test
	public void testFindComidaByTipo() throws Exception {
		List<Comida> comida = comidaDao.findByTipo("desayuno");
		assertTrue(comida.size() > 0);
	}

}
