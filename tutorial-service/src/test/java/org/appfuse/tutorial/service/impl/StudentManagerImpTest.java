package org.appfuse.tutorial.service.impl;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.appfuse.tutorial.dao.StudentDao;
import org.appfuse.tutorial.model.Student;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class StudentManagerImpTest extends BaseManagerMockTestCase {
	@InjectMocks
	private StudentManagerImpl manager;

	@Mock
	private StudentDao dao;

	@Test
	public void testIncrementCount() {
		log.debug("testing testIncrementCount...");
		// given
		final Long id = 1L;
		final Long count = 1L;
		final Student student = new Student();

		student.setCount(count);

		given(dao.get(id)).willReturn(student);

		// when
		Long resultCount = manager.incrementCount(1L);

		// then
		assertTrue(resultCount > count);
	}

	@Test
	public void testNullIncrementCount() {
		log.debug("testing testIncrementCount...");
		// given
		final Long id = 1L;
		final Student student = new Student();

		given(dao.get(id)).willReturn(student);

		// when
		Long resultCount = manager.incrementCount(1L);

		// then
		assertSame(resultCount, 0l);
	}
}
