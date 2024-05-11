package com.coderscampus.ass11.repository;

import com.coderscampus.ass11.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    private Map<Integer, Person> people = new HashMap<>();

    public Person save(Person person) {
        people.put(person.getId(), person);
        return person;
    }

    public Person findById(Integer personId) {

        return people.get(personId);
    }

    public List<Person> findAll() {
        return people.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
    }

    public void delete(Integer personId) {
        people.remove(personId);
    }
}
