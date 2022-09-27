package com.example.testTask.rep;

import com.example.testTask.entity.User;

public interface UserRepository extends GeneralRepository<User>{
    User findByLogin(String login);
}
