package org.appfuse.tutorial.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class CompanyDaoTest extends BaseDaoTestCase {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testFindCompanyByName() throws Exception {
        List<Company> company = companyDao.findByName("Akamai");
        assertTrue(company.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveCompany() throws Exception {
        Company company = new Company();
        company.setName("Akamai");
        company.setTax(new Double(30));

        company = companyDao.save(company);
        flush();

        company = companyDao.get(company.getCompanyId());

        assertEquals("Akamai", company.getName());
        assertNotNull(company.getCompanyId());


        companyDao.remove(company.getCompanyId());
        flush();

        // should throw DataAccessException
        companyDao.get(company.getCompanyId());
    }
}