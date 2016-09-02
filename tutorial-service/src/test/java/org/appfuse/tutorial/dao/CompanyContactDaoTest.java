package org.appfuse.tutorial.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.CompanyContact;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class CompanyContactDaoTest extends BaseDaoTestCase {
    @Autowired
    private CompanyContactDao companyContactDao;

    @Test
    public void testFindCompanyByName() throws Exception {
        List<CompanyContact> company = companyContactDao.findByName("Maikol");
        assertTrue(company.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveCompanyContact() throws Exception {
        CompanyContact companyContact = new CompanyContact();
        companyContact.setName("Maikol");
        companyContact.setPhone("123456");

        companyContact = companyContactDao.save(companyContact);
        flush();

        companyContact = companyContactDao.get(companyContact.getCompanyContactId());

        assertEquals("Akamai", companyContact.getName());
        assertNotNull(companyContact.getCompanyContactId());


        companyContactDao.remove(companyContact.getCompanyContactId());
        flush();

        // should throw DataAccessException
        companyContactDao.get(companyContact.getCompanyContactId());
    }
}