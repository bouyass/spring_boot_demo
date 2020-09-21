package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPersons() {
        Person person = new Person(UUID.randomUUID(), "Lyes from postres DB");
        return Arrays.asList(person);
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int removePerson(UUID id) {
        return 0;
    }

    @Override
    public int updatePerson(Person person) {
        return 0;
    }
}
