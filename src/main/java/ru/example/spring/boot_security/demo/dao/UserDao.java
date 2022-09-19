package ru.example.spring.boot_security.demo.dao;

import ru.example.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> findAll();
    User findByUsername(String username);
    void delete(Long id);
    void update(User user);
    User getUserById(Long id);
}
