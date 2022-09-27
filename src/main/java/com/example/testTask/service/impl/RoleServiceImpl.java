package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Role;
import com.example.testTask.rep.RoleRepository;

public class RoleServiceImpl extends GeneralServiceImpl<Role> {
    public RoleServiceImpl (RoleRepository roleRepository, Specifications<Role> roleSpecifications) {
        super(roleRepository, roleSpecifications);
    }

    @Override
    protected void validate(Role object) {
        if (object.getName()==null) {
            throw new RuntimeException("Данные не заполнены");
        }
    }
}
