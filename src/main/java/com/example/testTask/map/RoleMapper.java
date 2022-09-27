package com.example.testTask.map;

import com.example.testTask.dto.RoleDto;
import com.example.testTask.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper extends GeneralMapper<Role, RoleDto> {
    @Override
    public RoleDto objectToDto(Role object) {
        RoleDto dto = new RoleDto();
        dto.setId(object.getId());
        dto.setName(object.getName());
        return dto;
    }

    @Override
    public Role dtoToObject(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
