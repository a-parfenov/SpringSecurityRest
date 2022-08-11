package ru.example.spring.boot_security.demo.service;

import ru.example.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    List<Role> getByName(String name);

}

