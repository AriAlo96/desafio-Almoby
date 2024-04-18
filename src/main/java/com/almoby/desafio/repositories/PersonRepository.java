package com.almoby.desafio.repositories;

import com.almoby.desafio.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person,String> {
    boolean existsClientByEmail(String Email);
}

