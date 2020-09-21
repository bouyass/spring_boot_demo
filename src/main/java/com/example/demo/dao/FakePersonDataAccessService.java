package com.example.demo.dao;


import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

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
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream().filter(item -> item.getId().equals(id)).findFirst();
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

    @Override
    public int updatePerson(Person person) {
        Iterator<Person> it = DB.iterator();
        while(it.hasNext()){
            Person tempPerson = it.next();
            if(tempPerson.getId().equals(person.getId())){
                DB.remove(tempPerson);
                DB.add(person);
                return 1; // the person updated successfully
            }
        }
        return 0; // the person data were not able to be updated
    }


}
