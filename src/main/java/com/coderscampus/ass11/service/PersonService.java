package com.coderscampus.ass11.service;

import com.coderscampus.ass11.domain.Person;
import com.coderscampus.ass11.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private Integer personId = 1;
    @Autowired
    PersonRepository personRepo;

    public Person save(Person person) {
        if (person.getId() == null) person.setId(personId++);
        return personRepo.save(person);
    }

    public Person findById(Integer personId) {
        return personRepo.findById(personId);
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public void delete(Integer personId) {
        personRepo.delete(personId);
    }
}
