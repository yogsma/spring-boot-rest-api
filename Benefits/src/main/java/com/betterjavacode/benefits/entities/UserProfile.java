package com.betterjavacode.benefits.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "UserProfile")
@Table(name = "userprofile")
public class UserProfile implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UserProfile() {

    }

    @JsonIgnore
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date dob;

    @Column
    private Date doh;

    @Column
    private String maritalstatus;

    @Column
    private String sex;

    @Column
    private String ssn;

    @Column
    private String weight;

    @Column
    private String height;

    @Column
    private String employmentstatus;

    @Column
    private Date terminationdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoh() {
        return doh;
    }

    public void setDoh(Date doh) {
        this.doh = doh;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEmploymentstatus() {
        return employmentstatus;
    }

    public void setEmploymentstatus(String employmentstatus) {
        this.employmentstatus = employmentstatus;
    }

    public Date getTerminationdate() {
        return terminationdate;
    }

    public void setTerminationdate(Date terminationdate) {
        this.terminationdate = terminationdate;
    }

}
