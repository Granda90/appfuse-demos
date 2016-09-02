package org.appfuse.tutorial.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.CompanyContact;

public interface CompanyContactDao extends GenericDao<CompanyContact, Long> {
	public List<CompanyContact> findByName(String name);

}
