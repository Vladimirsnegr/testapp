package com.example.testTask.map;

import com.example.testTask.dto.UserDto;
import com.example.testTask.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends GeneralMapper<User, UserDto> {
    @Override
    public UserDto objectToDto(User object) {
        UserDto dto = new UserDto();
        dto.setId(object.getId());
        dto.setName(object.getName());
        dto.setLogin(object.getLogin());
        //dto.setPassword(object.getPassword());
        dto.setRoles(object.getRoles());
        dto.getRoles().forEach(role -> {role.setUsers(null);});
        return dto;
    }

    @Override
    public User dtoToObject(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setRoles(dto.getRoles());
        user.setPasswordConfirm(dto.getPasswordConfirm());
        return user;
    }
}
