package ru.example.spring.boot_security.demo.dao;

import ru.example.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role user);
    List<Role> listRoles();
    List<Role> getByName(String name);
}
