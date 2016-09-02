package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.CompanyDao;
import org.appfuse.tutorial.model.Company;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("companyDao")
public class CompanyDaoHibernate extends GenericDaoHibernate<Company, Long> implements CompanyDao {

	public CompanyDaoHibernate() {
		super(Company.class);
	}

	@Override
	public List<org.appfuse.tutorial.model.Company> findByName(String name) {
		return getSession().createCriteria(Company.class).add(Restrictions.eq("name", name)).list();
	}

}
