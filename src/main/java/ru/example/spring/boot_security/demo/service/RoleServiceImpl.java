package ru.example.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.spring.boot_security.demo.dao.RoleDao;
import ru.example.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRole() {
        return roleDao.listRoles();
    }

    @Override
    public List<Role> getByName(String name) {
        return roleDao.getByName(name);
    }
}
