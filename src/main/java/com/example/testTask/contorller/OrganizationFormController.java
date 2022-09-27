package com.example.testTask.contorller;

import com.example.testTask.dto.OrganizationFormDto;
import com.example.testTask.entity.OrganizationForm;
import com.example.testTask.map.OrganizationFormMapper;
import com.example.testTask.service.impl.OrganizationFormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/organizationForms")
public class OrganizationFormController extends GeneralController<OrganizationForm, OrganizationFormDto>{

    @Autowired
    public OrganizationFormController(OrganizationFormServiceImpl formService, OrganizationFormMapper formMapper) {
        super(formService,formMapper);
    }
}
