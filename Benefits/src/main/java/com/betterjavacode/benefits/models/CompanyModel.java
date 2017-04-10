package com.betterjavacode.benefits.models;

import java.io.Serializable;
import java.util.Date;

public class CompanyModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5977016561068828540L;

    private String companyname;

    private String status;

    private Date establisheddate;

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEstablisheddate() {
        return establisheddate;
    }

    public void setEstablisheddate(Date establisheddate) {
        this.establisheddate = establisheddate;
    }

}
