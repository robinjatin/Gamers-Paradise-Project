package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByFirstName(String firstName);
    public List<Person> findByAge(int age);
}
