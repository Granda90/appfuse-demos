package org.appfuse.tutorial.service;

import org.appfuse.service.GenericManager;
import org.appfuse.tutorial.dto.PersonDTO;
import org.appfuse.tutorial.model.Person;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.List;

@WebService
@Path("/people")
public interface PersonManager extends GenericManager<Person, Long> {

	@GET
	@Path("{firstname}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<PersonDTO> findByFirstName(@PathParam("firstname") String firstname);
	// URL: /services/api/people/Matt
	
	@GET
	@Path("/search/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<PersonDTO> findByLastName(@QueryParam("lastname") String lastName);
	// URL: /services/api/people/search?lastname=Raible

	@GET
	@Path("/email/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<PersonDTO> findByEmail(@QueryParam("email") String email);
	// URL: /services/api/people/email?email=matt@email.com
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<PersonDTO> getPeople();
}