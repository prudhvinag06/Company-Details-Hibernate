package com.example.erp.service;

import com.example.erp.bean.Company;
import com.example.erp.dao.CompanyDao;
import com.example.erp.dao.implementation.CompanyDaoImpl;

import java.util.List;

public class CompanyService {
    CompanyDao company = new CompanyDaoImpl();
    public Company verifyEmail(Company c){
        return company.emailVerify(c);
    }

    public boolean registerCompany(Company s){
        return company.registerCompany(s);
    }

    public boolean deleteCompany(Company s){
        return company.deleteCompany(s);
    }

    public List<Company> viewDetails(Company s) {
        return company.viewDetails(s);
    }

    public boolean updateCompany(Company c) { return company.updateDetails(c);}
}
