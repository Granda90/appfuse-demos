package org.appfuse.tutorial.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.tutorial.dao.PersonDao;
import org.appfuse.tutorial.dto.PersonDTO;
import org.appfuse.tutorial.mapper.PersonMapper;
import org.appfuse.tutorial.model.Person;
import org.appfuse.tutorial.service.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("personManager")
@WebService(serviceName = "PersonService", endpointInterface = "org.appfuse.tutorial.service.PersonManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long>implements PersonManager {
	PersonDao personDao;

	public PersonManagerImpl() {
	}

	@Autowired
	public PersonManagerImpl(PersonDao personDao) {
		super(personDao);
		this.personDao = personDao;
	}

	public List<PersonDTO> findByFirstName(String firstName) {
		List<PersonDTO> personDTOs = null;
		List<Person> personList = personDao.findByFirstName(firstName);

		personDTOs = PersonMapper.INSTANCE.personsToPersonsDTOs(personList);

		return personDTOs;
	}

	public List<PersonDTO> findByLastName(String lastName) {
		List<PersonDTO> personDTOs = null;
		List<Person> personList = personDao.findByLastName(lastName);

		personDTOs = PersonMapper.INSTANCE.personsToPersonsDTOs(personList);

		return personDTOs;
	}

	public List<PersonDTO> findByEmail(String email) {
		List<PersonDTO> personDTOs = null;
		List<Person> personList = personDao.findByEmail(email);

		personDTOs = PersonMapper.INSTANCE.personsToPersonsDTOs(personList);

		return personDTOs;
	}

	public List<PersonDTO> getPeople() {
		List<PersonDTO> personDTOs = null;
		List<Person> personList = personDao.getAll();

		personDTOs = PersonMapper.INSTANCE.personsToPersonsDTOs(personList);

		return personDTOs;
	}
}