package com.example.orm.loginorm.dao;

import com.example.orm.loginorm.model.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserH2DAO implements UserDAO {

    private final List<User> userList = Stream.of(
            new User (1, "Adam", "adam11"),
            new User (2, "Robert", "robert22"),
            new User (3, "Krzysiek", "krzysiek33"),
            new User (4, "Darek", "darek44"),
            new User (5, "Paweł", "pawel55"))
            .collect(Collectors.toList());

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void updateUser(User user) {
        List<User> tempList = userList.stream()
                .filter(newUser -> newUser.getId() == user.getId())
                .collect(Collectors.toList());

        tempList.get(0).setName(user.getName());
        tempList.get(0).setPassword(user.getPassword());
    }

    @Override
    public void deleteUser(long id) {
        userList.stream()
                .filter(tempUser -> tempUser.getId() == id)
                .map(deleteUser -> userList.remove(deleteUser))
                .findAny();
    }
}
