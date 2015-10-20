package org.appfuse.tutorial.mapper;


import java.util.List;

import org.appfuse.tutorial.dto.PersonDTO;
import org.appfuse.tutorial.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	List<PersonDTO> personsToPersonsDTOs(List<Person> persons);
	
	@Mappings({ 
		@Mapping(source = "personId", target = "personId"),
		@Mapping(source = "personEmail", target = "personEmail"),		
		@Mapping(source = "firstName", target = "firstName"), 
		@Mapping(source = "lastName", target = "lastName") 
		})
	PersonDTO personToPersonDTO(Person person);
}
