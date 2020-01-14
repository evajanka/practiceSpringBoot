package com.janka.spring.practice.springprac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PersonService {

    private final PersonDB personDB;

    @Autowired
    public PersonService(@Qualifier("PersonData") PersonDB personDB) {
        this.personDB = personDB;
    }

    public int addPerson(Person person){
        return personDB.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDB.SelectAll();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDB.SelectPersonById(id);
    }

    public int DeletePerson(UUID id){
        return personDB.deletePerson(id);
    }

    public int updatePerson(UUID id, Person person){
        return personDB.updatePerson(id, person);
    }
}
