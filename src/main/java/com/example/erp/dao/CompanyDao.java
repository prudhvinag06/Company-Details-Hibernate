package com.example.erp.dao;


import com.example.erp.bean.Company;

import java.util.List;

public interface CompanyDao {
    Company emailVerify(Company student);

    boolean registerCompany(Company student);

    boolean deleteCompany(Company s);

    List<Company> viewDetails(Company s);

    boolean updateDetails(Company c);
}
