package org.appfuse.tutorial.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.tutorial.model.PersonEmail;

@XmlRootElement(name = "person")
public class PersonDTO {
	private Long personId;
	private PersonEmail[] personEmail;
	private String firstName;
	private String lastName;

	public PersonDTO() {
		super();
	}

	public PersonDTO(Long personId, PersonEmail[] personEmail, String firstName, String lastName) {
		super();
		this.personId = personId;
		this.personEmail = personEmail;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public PersonEmail[] getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(PersonEmail[] personEmail) {
		this.personEmail = personEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "PersonDTO [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
