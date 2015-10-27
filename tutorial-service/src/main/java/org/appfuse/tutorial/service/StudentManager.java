package org.appfuse.tutorial.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.appfuse.service.GenericManager;
import org.appfuse.tutorial.model.Student;

@WebService
@Path("/student")
public interface StudentManager extends GenericManager<Student, Long> {

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Long incrementCount(@PathParam("id") Long id);

}
