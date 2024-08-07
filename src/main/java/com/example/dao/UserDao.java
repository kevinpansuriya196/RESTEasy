package com.example.dao;

import com.example.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class UserDao {

    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void deleteUser(int id) {
        User user = findUserById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
