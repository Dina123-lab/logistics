package com.logistics.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class clearance {
    @Id
    private int clearanceId;
    private String name;
    private String email;
    private String phone;
    private String companyname;
    private String clearancetype;

    public clearance() {
    }

    public clearance(int clearanceId, String name, String email, String phone, String companyname, String clearancetype) {
        this.clearanceId = clearanceId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.companyname = companyname;
        this.clearancetype = clearancetype;
    }

    public int getClearanceId() {
        return clearanceId;
    }

    public void setClearanceId(int clearanceId) {
        this.clearanceId = clearanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getClearancetype() {
        return clearancetype;
    }

    public void setClearancetype(String clearancetype) {
        this.clearancetype = clearancetype;
    }
}
