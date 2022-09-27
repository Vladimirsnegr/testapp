package com.example.testTask.entity;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends GeneralEntity{
    private String shortName;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="form_of_organization_id",nullable = false)
    private OrganizationForm organizationForm;

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setOrganizationForm(OrganizationForm organizationForm) {
        this.organizationForm = organizationForm;
    }

    public OrganizationForm getOrganizationForm() {
        return organizationForm;
    }
}
