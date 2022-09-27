package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.OrganizationForm;
import com.example.testTask.rep.OrganizationFormRepository;

public class OrganizationFormServiceImpl extends GeneralServiceImpl<OrganizationForm> {

   public OrganizationFormServiceImpl(OrganizationFormRepository organizationFormRepository, Specifications<OrganizationForm> specifications) {
       super(organizationFormRepository, specifications);
   }

    @Override
    protected void validate(OrganizationForm object) {
        if (object.getName()==null) {
            throw new RuntimeException("Данные не заполнены");
        }
    }
}
