package com.example.testTask.dto;

import com.example.testTask.entity.OrganizationForm;


public class ClientDto extends GeneralDto{
    private String name;
    private String shortName;
    private String address;
    private OrganizationForm organizationForm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrganizationForm getOrganizationForm() {
        return organizationForm;
    }

    public void setOrganizationForm(OrganizationForm organizationForm) {
        this.organizationForm = organizationForm;
    }
}
