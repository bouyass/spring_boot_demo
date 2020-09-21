package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @RequestMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    @RequestMapping("/getAllPersons")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Person getPersonById(@PathVariable UUID id){
        if (personService.getPersonById(id) == null) {
            return null;
        }
        return personService.getPersonById(id);
    }

    @GetMapping
    @RequestMapping("/delete/{id}")
    public int removePerson(@PathVariable UUID id){
        return personService.removePerson(id);
    }

    @PostMapping
    @RequestMapping("/update")
    public int updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }
}
