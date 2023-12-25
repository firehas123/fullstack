package com.backend.controller;

import com.backend.controller.request.AddPersonRequest;
import com.backend.controller.request.FetchPersonRequest;
import com.backend.model.Person;
import com.backend.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/add")
    public void addPerson(@RequestBody AddPersonRequest request) {
        Person person = new Person();
        person.setName(request.getName());
        personRepository.save(person);
    }

    @GetMapping("/fetch")
    public List<Person> fetchPersons(@RequestBody FetchPersonRequest request) {
        // Implement fetching logic based on request parameters if needed
        return personRepository.findAll();
    }
}

