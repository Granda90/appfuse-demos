package org.appfuse.tutorial.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Student;

public interface StudentDao extends GenericDao<Student, Long> {
	public List<Student> findByName(String student);
}
