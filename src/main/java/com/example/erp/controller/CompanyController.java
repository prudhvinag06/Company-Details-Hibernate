package com.example.erp.controller;

import com.example.erp.bean.Company;
import com.example.erp.bean.Courses;
import com.example.erp.service.CompanyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("company")
public class CompanyController {
    CompanyService companyService = new CompanyService();
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerStudent(Company company) throws URISyntaxException {
//
        System.out.println("Reached Here /////////////");
        System.out.println("Company name" + company.getCompany_name());
        if(companyService.registerCompany(company)){
            return Response.ok().build();
        }else{
            return Response.status(203).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginStudent(Company company) throws URISyntaxException {

        Company result = companyService.verifyEmail(company);
        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent(Company company) throws URISyntaxException {

        boolean result = companyService.deleteCompany(company);
        if(result)
            return Response.ok().build();

        return Response.status(203).build();
    }

    @GET
    @Path("/view")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewDetails(Company company) throws URISyntaxException {
//        System.out.println("dfsdfsdfsdfdsfsdfsdfdsfsfsdfsdfsdf");
        List<Company> companyList = companyService.viewDetails(company);
        System.out.println("Company details : " + companyList);
        return Response.ok().entity(companyList).build();
    }


    @POST
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSpecialization(Company company) throws URISyntaxException {

        if(companyService.updateCompany(company)){
            return Response.ok().build();
        }
        return Response.status(203).build();

    }


}
