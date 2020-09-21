package com.example.demo.dao;


import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return DB;
    }

    @Override
    public Person getPersonById(UUID id) {
        Iterator<Person> it = DB.iterator();
        while(it.hasNext()){
            Person tempPerson = it.next();
            if(tempPerson.getId().equals(id)){
                return tempPerson;
            }
        }
        return null;
    }

    @Override
    public int removePerson(UUID id) {
        Iterator<Person> it = DB.iterator();
        while(it.hasNext()){
            Person tempPerson = it.next();
            if(tempPerson.getId().equals(id)){
                DB.remove(tempPerson);
                return 1; // the person has been deleted
            }
        }
        return 0; // the persons doesn't exist in the list
    }


}