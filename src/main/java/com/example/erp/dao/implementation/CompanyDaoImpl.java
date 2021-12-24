package com.example.erp.dao.implementation;

import com.example.erp.bean.Company;
import com.example.erp.dao.CompanyDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    @Override
    public Company emailVerify(Company company) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Company where email=:email");
            query.setParameter("email", company.getEmail());
            for (final Object fetch : query.list()) {
                return (Company) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public boolean registerCompany(Company company) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            System.out.println(company.getCompany_id());
            System.out.println(company.getCompany_name());
            System.out.println(company.getEmail());
            session.save(company);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCompany(Company s) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("delete from Company where email=:email");
            query.setParameter("email", s.getEmail());

            Transaction transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            session.close();

            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Company> viewDetails(Company s) {
        List<Company> companyList = new ArrayList<>();
        Session session = SessionUtil.getSession();
        try {
            for (final Object spec : session.createQuery("from Company ").list()) {
                companyList.add((Company) spec);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return companyList;

    }

    @Override
    public boolean updateDetails(Company company) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("update Company set hr_name=:hr_name,company_name=:company_name,email=:email where company_id=:company_id");
            query.setParameter("hr_name", company.getHr_name());
            query.setParameter("company_name", company.getCompany_name());
            query.setParameter("email", company.getEmail());
            query.setParameter("company_id", company.getCompany_id());

            Transaction transaction = session.beginTransaction();
            int result = query.executeUpdate();
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }


}
