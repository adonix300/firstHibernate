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
    @Query("SELECT p from Person p where p.city.name= :city")
    List<Person> findAllByCity(String city);

    @Query("SELECT p FROM Person p where p.contact.age < :age order by p.contact.age asc")
    List<Person> findByContactAgeLessThanOrderByContactAgeAsc(int age);

    @Query("SELECT p FROM Person p where p.contact.name = :name and p.contact.surname = :surname")
    Optional<Person> findByContactNameAndContactSurname(String name, String surname);
}
