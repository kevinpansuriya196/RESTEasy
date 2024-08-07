package com.example.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {


    private EntityManagerFactory entityManagerFactory;

    public EntityManagerProducer() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
    }

    @Produces
    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager(EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
