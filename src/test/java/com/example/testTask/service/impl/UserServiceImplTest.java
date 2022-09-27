package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Role;
import com.example.testTask.entity.User;
import com.example.testTask.rep.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest extends GeneralTest<User> {
    @Override
    @BeforeEach
    @SuppressWarnings("unchecked")
    protected void setUp() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Specifications<User> userSpecifications = Mockito.mock(Specifications.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
        UserServiceImpl userService = Mockito.spy(new UserServiceImpl(userRepository,userSpecifications,bCryptPasswordEncoder));

        super.repository = userRepository;
        super.specifications = userSpecifications;
        super.service = userService;
    }

    @Test
    void loadUserByUsernameTest () {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Specifications<User> userSpecifications = Mockito.mock(Specifications.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
        UserServiceImpl userService = Mockito.spy(new UserServiceImpl(userRepository,userSpecifications,bCryptPasswordEncoder));

        User user = getObject();

        when(userRepository.findByLogin(anyString())).thenReturn(user);

        UserDetails result = userService.loadUserByUsername(user.getUsername());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(user.getUsername(),result.getUsername());
    }

    @Override
    protected List<User> getObjects() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        user1.setLogin("login1");
        user1.setPassword("qwerty123");

        User user2 = new User();
        user2.setId(2L);
        user2.setLogin("login2");
        user2.setPassword("qwerty223");

        users.add(user1);
        users.add(user2);
        return users;
    }

    @Override
    protected User getObject() {
        User user = new User();
        user.setId(1L);
        user.setLogin("login");
        user.setPassword("qwerty123");
        user.setPasswordConfirm("qwerty123");

        List<Role> roles = getRoles();
        user.setRoles(roles);
        user.setName("name");
        return user;
    }

    private List<Role> getRoles() {
        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("testRole1");

        Role role2 = new Role();
        role2.setId(2L);
        role2.setName("testRole2");

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);
        return roles;
    }

    @Override
    protected User updateObject(User object) {
        object.setName("updated"+object.getName());
        object.setLogin("updated"+object.getLogin());
        object.setPassword("updatedPassword");
        object.setPasswordConfirm("updatedPassword");
        return object;
    }
}
