package com.almoby.desafio.controllers;

import com.almoby.desafio.models.Person;
import com.almoby.desafio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/persons")
    public ResponseEntity<Object> register(
            @RequestParam String fullName,
            @RequestParam String email, @RequestParam String password, @RequestParam String confirmPassword) {

        if (fullName.isBlank() || fullName.isEmpty()) {
            return new ResponseEntity<>("You must enter your full name",
                    HttpStatus.FORBIDDEN);
        }

        if (email.isBlank() || email.isEmpty()) {
            return new ResponseEntity<>("You must enter your email",HttpStatus.FORBIDDEN);
        }

        if (password.isBlank() || password.isEmpty()) {
            return new ResponseEntity<>("You must enter your password",HttpStatus.FORBIDDEN);
        }

        if (!password.equals(confirmPassword)){
            return new ResponseEntity<>("Passwords do not match", HttpStatus.FORBIDDEN);
        }

        if (personRepository.existsClientByEmail(email)) {
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }
        Person newPerson = new Person(fullName, email, password);
        personRepository.save(newPerson);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

