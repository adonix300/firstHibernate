package com.example.userstable.repositories;

import com.example.userstable.models.City;
import com.example.userstable.models.Contact;
import com.example.userstable.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Contact> {
    List<Person> findAllByCity(City city);
    List<Person> findByContactAgeLessThanOrderByContactAgeAsc(int age);
    Optional<Person> findByContactNameAndContactSurname(String name, String surname);
}
