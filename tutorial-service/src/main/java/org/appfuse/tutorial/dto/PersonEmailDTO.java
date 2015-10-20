package org.appfuse.tutorial.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="personEmail")
public class PersonEmailDTO {
	private Long personEmailId;
	private String email;
	private String emailType;

	public PersonEmailDTO() {
		super();
	}

	public PersonEmailDTO(Long personEmailId, String email, String emailType) {
		super();
		this.personEmailId = personEmailId;
		this.email = email;
		this.emailType = emailType;
	}

	public Long getPersonEmailId() {
		return personEmailId;
	}

	public void setPersonEmailId(Long personEmailId) {
		this.personEmailId = personEmailId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	@Override
	public String toString() {
		return "PersonEmailDTO [personEmailId=" + personEmailId + ", email=" + email + ", emailType=" + emailType + "]";
	}

}
