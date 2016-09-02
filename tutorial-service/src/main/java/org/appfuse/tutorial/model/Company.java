package org.appfuse.tutorial.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

@Entity
@Table(name = "company")
public class Company extends BaseObject {
	private Long companyId;
	private String name;
	private Double tax;
	private Set<CompanyContact> companyContact;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id", unique = true, nullable = false)
	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "tax")
	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
	public Set<CompanyContact> getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(Set<CompanyContact> companyContact) {
		this.companyContact = companyContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyContact == null) ? 0 : companyContact.hashCode());
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
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
		Company other = (Company) obj;
		if (companyContact == null) {
			if (other.companyContact != null)
				return false;
		} else if (!companyContact.equals(other.companyContact))
			return false;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", tax=" + tax + ", companyContact="
				+ companyContact + "]";
	}

}
