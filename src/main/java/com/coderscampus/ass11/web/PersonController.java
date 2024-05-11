package com.coderscampus.ass11.web;

import com.coderscampus.ass11.domain.Person;
import com.coderscampus.ass11.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public String getPeople(ModelMap model) {

        List<Person> people = personService.findAll();

        Person person = new Person();
        model.put("person", person);
        model.put("people", people);
        return "people";
    }

    @GetMapping("/persons/{personId}")
    public String getPerson(@PathVariable Integer personId, ModelMap model) {
        Person person = personService.findById(personId);
        model.put("person", person);
        return "people";
    }

    //new person
    @PostMapping("/persons")
    public String postPeople(Person person) {
        Person savedPerson = personService.save(person);
        System.out.println(savedPerson);
        return "redirect:/persons";
    }

    //exsting person - editing
    @PostMapping("/persons/{personId}")
    public String postPerson (Person person) {
        Person savedPerson = personService.save(person);
        System.out.println(savedPerson);
        return "redirect:/persons/" + savedPerson.getId();
    }

    @PostMapping("/persons/{personId}/delete")
    public String deletePerson (@PathVariable Integer personId) {
        personService.delete(personId);
        return "redirect:/persons";
    }



}