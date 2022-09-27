package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Role;
import com.example.testTask.rep.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RoleServiceImplTest extends GeneralTest<Role> {

    @Override
    @BeforeEach
    @SuppressWarnings("unchecked")
    protected void setUp() {
        RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
        Specifications<Role> roleSpecifications = Mockito.mock(Specifications.class);
        RoleServiceImpl roleService = Mockito.spy(new RoleServiceImpl(roleRepository, roleSpecifications));

        super.repository=roleRepository;
        super.specifications=roleSpecifications;
        super.service=roleService;
    }

    @Override
    protected List<Role> getObjects() {
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("name1");

        Role role2 = new Role();
        role2.setId(2L);
        role2.setName("name2");

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        return roles;
    }

    @Override
    protected Role getObject() {
        Role role = new Role();
        role.setId(1L);
        role.setName("name");
        return role;
    }

    @Override
    protected Role updateObject(Role object) {
        object.setName("updated"+object.getName());
        return object;
    }
}
