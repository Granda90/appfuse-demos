package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.StudentDao;
import org.appfuse.tutorial.model.Student;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoHibernate extends GenericDaoHibernate<Student, Long>implements StudentDao {

	public StudentDaoHibernate() {
		super(Student.class);
	}

	@Override
	public List<Student> findByName(String name) {
		return getSession().createCriteria(Student.class).add(Restrictions.eq("name", name)).list();
	}

}
