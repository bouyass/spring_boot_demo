package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.dao.PersonRepo;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class NewPersonService {

    @Autowired
    private final PersonRepo personRepo;

    public NewPersonService(PersonRepo personRepo){
        this.personRepo = personRepo;
    }

    public Person addPerson(Person person){
        person.setId(UUID.randomUUID());
        return personRepo.save(person);
    }

    public List<Person> getAllPersons(){
        List<Person> target = new ArrayList<>();
        personRepo.findAll().forEach(target::add);
        return target;
    }

    public Optional<Person> getPersonById(UUID id){
       return personRepo.findById(id);
    }

    public void removePerson(UUID id){
         personRepo.deleteById(id);
    }

    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }
}
