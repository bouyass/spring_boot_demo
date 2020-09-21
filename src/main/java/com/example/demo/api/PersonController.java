package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.NewPersonService;
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
    @Autowired
    private final NewPersonService newPersonService;

    public PersonController(PersonService personService, NewPersonService newPersonService){
        this.personService = personService;
        this.newPersonService = newPersonService;
    }

    @PostMapping
    @RequestMapping("/addPerson")
    public void addPerson(@RequestBody Person person){
        newPersonService.addPerson(person);
    }

    @GetMapping
    @RequestMapping("/getAllPersons")
    public List<Person> getAllPersons(){
        return newPersonService.getAllPersons();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Person getPersonById(@PathVariable UUID id){
        return newPersonService.getPersonById(id).orElse(null);
    }

    @GetMapping
    @RequestMapping("/delete/{id}")
    public void removePerson(@PathVariable UUID id){
         newPersonService.removePerson(id);
    }

    @PostMapping
    @RequestMapping("/update")
    public void updatePerson(@RequestBody Person person){
         newPersonService.updatePerson(person);
    }
}
