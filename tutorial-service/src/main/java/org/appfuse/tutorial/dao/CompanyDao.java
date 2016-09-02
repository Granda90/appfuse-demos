package org.appfuse.tutorial.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.tutorial.model.Company;

public interface CompanyDao extends GenericDao<Company, Long>  {
	public List<Company> findByName(String name);

}
