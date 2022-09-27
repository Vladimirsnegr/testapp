package com.example.testTask.contorller;

import com.example.testTask.dto.UserDto;
import com.example.testTask.map.UserMapper;
import com.example.testTask.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    public RegistrationController(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/registration")
    public UserDto registration(@RequestBody UserDto dto) {
        return userMapper.objectToDto(userService.saveObject(userMapper.dtoToObject(dto)));
    }
}
