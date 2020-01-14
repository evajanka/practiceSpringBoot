package com.janka.spring.practice.springprac;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PersonData")
class fakePersonData implements PersonDB {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> SelectAll() {
        return DB;
    }

    @Override
    public Optional<Person> SelectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> isPersonExist = SelectPersonById(id);
        if(isPersonExist.isEmpty()){
        return 0;}
        DB.remove(isPersonExist.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return SelectPersonById(id)
                .map(person1 -> {
                    int index = DB.indexOf(person);
                    if(index>=0){
                        DB.set(index, person);
                        return 1;
                    }return 0;
                }).orElse(0);
    }
}
