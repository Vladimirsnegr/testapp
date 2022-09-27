package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.User;
import com.example.testTask.rep.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl extends GeneralServiceImpl<User> implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, Specifications<User> specifications, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(userRepository, specifications);
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void validate(User object) {
        if (object.getPassword()==null||object.getLogin()==null||object.getName()==null||object.getPasswordConfirm()==null||object.getRoles()==null) {
            throw new RuntimeException("Данные не заполнены");
        }
    }

    @Override
    public User saveObject(User object) {
        if (!object.getPasswordConfirm().equals(object.getPassword())) {
            throw new RuntimeException("Пароли не совпадают");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User savedUser = object;
        savedUser.setPassword(encoder.encode(object.getPassword()));
        return super.saveObject(savedUser);
    }

    @Override
    public User updateObject(User object) {
        if (!object.getPassword().equals(object.getPasswordConfirm())) {
            throw new RuntimeException("Пароли не совпадают");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User savedUser = object;
        savedUser.setPassword(encoder.encode(object.getPassword()));
        return super.updateObject(savedUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);

        if (user==null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return user;
    }
}
