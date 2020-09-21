package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepo extends CrudRepository<Person, UUID> {
}
