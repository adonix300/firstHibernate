package com.example.userstable.controllers;

import com.example.userstable.models.City;
import com.example.userstable.models.Person;
import com.example.userstable.repositories.DBRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DBController {
    final DBRepository repository;

    public DBController(DBRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    List<Person> getPersonsByCity(@Validated City city) {
        return repository.getPersonsByCity(city.getName());
    }
}
