package com.example.testTask.contorller;

import com.example.testTask.dto.UserDto;
import com.example.testTask.entity.User;
import com.example.testTask.map.UserMapper;
import com.example.testTask.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController extends GeneralController<User, UserDto> {
    public UserController(UserServiceImpl userService, UserMapper userMapper) {
        super(userService, userMapper);
    }
}
