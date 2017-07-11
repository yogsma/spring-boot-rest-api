package com.betterjavacode.benefits.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Company")
@Table(name = "company")
public class Company implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Company(int id, String name, String type, String ein, CompanyProfile cp) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.ein = ein;
        this.cp = cp;
    }

    public Company() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int statusid;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "companyprofileid")
    private CompanyProfile cp;

    @Column
    private String type;

    @Column
    private String ein;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    public CompanyProfile getCp() {
        return cp;
    }

    public void setCp(CompanyProfile cp) {
        this.cp = cp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

}
