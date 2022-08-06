package ru.example.spring.boot_security.demo.service;

import ru.example.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class RoleService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveRole(Role role) {
        entityManager.persist(role);
    }
}
