package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.PersonDao;
import org.appfuse.tutorial.model.Person;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long>implements PersonDao {

	public PersonDaoHibernate() {
		super(Person.class);
	}

	@SuppressWarnings("unchecked")
	public List<Person> findByFirstName(String firstName) {
		return getSession().createCriteria(Person.class).add(Restrictions.eq("firstName", firstName)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Person> findByLastName(String lastName) {
		return getSession().createCriteria(Person.class).add(Restrictions.eq("lastName", lastName)).list();
	}

	public List<Person> findByEmail(String email) {
		@SuppressWarnings("unchecked")
		List<Person> personList = getSession().createCriteria(Person.class).createAlias("personEmail", "pe")
				.add(Restrictions.eq("pe.email", email)).list();
		return personList;
	}
}