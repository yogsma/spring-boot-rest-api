package com.betterjavacode.benefits.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CompanyProfile")
@Table(name = "companyprofile")
public class CompanyProfile implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CompanyProfile() {

    }

    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date establisheddate;

    @Column
    private String status;

    @Column
    private String corporationtype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEstablisheddate() {
        return establisheddate;
    }

    public void setEstablisheddate(Date establisheddate) {
        this.establisheddate = establisheddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCorporationtype() {
        return corporationtype;
    }

    public void setCorporationtype(String corporationtype) {
        this.corporationtype = corporationtype;
    }

}
