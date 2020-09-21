package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    List<Person> getAllPersons();
    Optional<Person> getPersonById(UUID id);
    int removePerson(UUID id);
    int updatePerson(Person person);

    default int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
