package org.appfuse.tutorial.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.tutorial.dao.CompanyContactDao;
import org.appfuse.tutorial.model.CompanyContact;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("companyContactDao")
public class CompanyContactDaoHibernate extends GenericDaoHibernate<CompanyContact, Long> implements CompanyContactDao {

    public CompanyContactDaoHibernate() {
        super(CompanyContact.class);
    }
	
	@Override
	public List<CompanyContact> findByName(String name) {
        return getSession().createCriteria(CompanyContact.class).add(Restrictions.eq("name", name)).list();
	}

}
