package com.janka.spring.practice.springprac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> GetAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("/path={id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping("/path={id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personService.DeletePerson(id);
    }

    @PutMapping("/path={id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person PersonToUpdate){
        personService.updatePerson(id, PersonToUpdate);
    }
}
