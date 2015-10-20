package org.appfuse.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "PersonEmail")
@Entity
@Table(name = "person_email")
public class PersonEmail extends BaseObject {
	private Long personEmailId;
	private Person person;
	private String email;
	private String emailType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_email_id", unique = true, nullable = false)
	public Long getPersonEmailId() {
		return personEmailId;
	}

	public void setPersonEmailId(Long personEmailId) {
		this.personEmailId = personEmailId;
	}

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	@JsonIgnore
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email_type", length = 50)
	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailType == null) ? 0 : emailType.hashCode());
		result = prime * result + ((personEmailId == null) ? 0 : personEmailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonEmail other = (PersonEmail) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailType == null) {
			if (other.emailType != null)
				return false;
		} else if (!emailType.equals(other.emailType))
			return false;
		if (personEmailId == null) {
			if (other.personEmailId != null)
				return false;
		} else if (!personEmailId.equals(other.personEmailId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonEmail [personEmailId=" + personEmailId + ", email=" + email + ", emailType=" + emailType + "]";
	}

}
