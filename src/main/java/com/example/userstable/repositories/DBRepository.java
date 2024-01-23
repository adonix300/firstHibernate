package com.example.userstable.repositories;

import com.example.userstable.models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DBRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = entityManager.createQuery(
                "from Person where city.name = :name", Person.class);
        query.setParameter("name", city);
        return query.getResultList();
    }
}
