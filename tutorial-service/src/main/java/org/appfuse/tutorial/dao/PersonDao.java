package org.appfuse.tutorial.dao;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Person;

import java.util.List;

public interface PersonDao extends GenericDao<Person, Long> {
	public List<Person> findByFirstName(String firstName);

	public List<Person> findByLastName(String lastName);

	public List<Person> findByEmail(String email);
}