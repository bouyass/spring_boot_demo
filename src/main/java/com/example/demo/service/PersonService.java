package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private final PersonDao personDao;

    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.addPerson(person);
    }

    public List<Person>  getAllPersons(){
        return personDao.getAllPersons();
    }

    public Person getPersonById(UUID id){
        return personDao.getPersonById(id);
    }

    public int removePerson(UUID id){
        return personDao.removePerson(id);
    }

    public int updatePerson(Person person){
        return personDao.updatePerson(person);
    }
}
