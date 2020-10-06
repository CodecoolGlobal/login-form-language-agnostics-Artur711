package com.example.orm.loginorm.dao;

import com.example.orm.loginorm.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
