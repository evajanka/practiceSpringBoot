package com.janka.spring.practice.springprac;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDB {

    public int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> SelectAll();

    Optional<Person> SelectPersonById(UUID id);

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);
}


