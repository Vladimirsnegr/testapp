package com.example.testTask.contorller;

import com.example.testTask.dto.RoleDto;
import com.example.testTask.entity.Role;
import com.example.testTask.map.RoleMapper;
import com.example.testTask.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleController extends GeneralController<Role, RoleDto> {

    public RoleController(RoleServiceImpl roleService, RoleMapper roleMapper) {
        super(roleService, roleMapper);
    }
}
