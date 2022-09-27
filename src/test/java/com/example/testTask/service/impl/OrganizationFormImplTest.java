package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.OrganizationForm;
import com.example.testTask.rep.OrganizationFormRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrganizationFormImplTest extends GeneralTest<OrganizationForm> {

    @Override
    @BeforeEach
    @SuppressWarnings("unchecked")
    protected void setUp() {
        OrganizationFormRepository formRepository = Mockito.mock(OrganizationFormRepository.class);
        Specifications<OrganizationForm> formSpecifications = Mockito.mock(Specifications.class);
        OrganizationFormServiceImpl formService = Mockito.spy(new OrganizationFormServiceImpl(formRepository, formSpecifications));

        super.repository = formRepository;
        super.specifications = formSpecifications;
        super.service = formService;
    }

    @Override
    protected List<OrganizationForm> getObjects() {
        OrganizationForm organizationForm1 = new OrganizationForm();
        organizationForm1.setId(1L);
        organizationForm1.setName("name1");

        OrganizationForm organizationForm2 = new OrganizationForm();
        organizationForm2.setId(2L);
        organizationForm2.setName("name2");

        List<OrganizationForm> organizationForms = new ArrayList<>();
        organizationForms.add(organizationForm1);
        organizationForms.add(organizationForm2);
        return organizationForms;
    }

    @Override
    protected OrganizationForm getObject() {
        OrganizationForm organizationForm = new OrganizationForm();
        organizationForm.setId(1L);
        organizationForm.setName("name");
        return organizationForm;
    }

    @Override
    protected OrganizationForm updateObject(OrganizationForm object) {
        object.setName("updated"+object.getName());
        return object;
    }
}
