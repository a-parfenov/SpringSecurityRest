package ru.example.spring.boot_security.demo.dao;

import org.springframework.stereotype.Component;
import ru.example.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public User findByUsername(String username) {
        return entityManager.createQuery("select u from User u join fetch u.roles where u.username = :id", User.class)
                .setParameter("id", username)
                .getResultList().stream().findAny().orElse(null);
    }

    public  void delete(Long id) {
        User us = entityManager.find(User.class, id);
        entityManager.remove(us);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("select s from User s", User.class).getResultList();
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
