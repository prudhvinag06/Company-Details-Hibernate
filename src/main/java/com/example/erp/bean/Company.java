package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer company_id;



    private String company_name;
    private String hr_name;
    @Column(nullable = false, unique = true)
    private String email;
    public Company() {
    }
    public Company(String company_name, String hr_name, String hr_email) {
        this.company_name = company_name;
        this.hr_name = hr_name;
        this.email = hr_email;
    }



    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getHr_name() {
        return hr_name;
    }

    public void setHr_name(String hr_name) {
        this.hr_name = hr_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }
}
