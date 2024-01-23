package com.example.userstable.controllers;

import com.example.userstable.models.City;
import com.example.userstable.models.Contact;
import com.example.userstable.models.Person;
import com.example.userstable.repositories.PersonRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class DBController {
    final PersonRepository repository;

    public DBController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/by-city")
    List<Person> findPersonsByCity(@Validated City city) {
        return repository.findAllByCity(city.getName());
    }

    @GetMapping("/by-age")
    List<Person> findPersonsByAge(@Validated Contact contact) {
        return repository.findByContactAgeLessThanOrderByContactAgeAsc(contact.getAge());
    }

    @GetMapping("/by-name-and-surname")
    Optional<Person> findPersonsByNameAndSurname(@Validated Contact contact){
        return repository.findByContactNameAndContactSurname(contact.getName(), contact.getSurname());
    }

}
