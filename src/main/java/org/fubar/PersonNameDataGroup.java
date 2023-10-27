package org.fubar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class PersonNameDataGroup {
    private final MyMap<Character, MyList<Person>> dataGroups;

    public PersonNameDataGroup() {
        dataGroups = new MyMap<>();
    }

    public void addPerson(Person person) {
        char firstLetter = person.lastName().charAt(0);
        MyList<Person> groupData = dataGroups.getOrDefault(firstLetter, new MyList<>());
        groupData.add(person);
        dataGroups.put(firstLetter, groupData);
    }

    public MyList<Person> getPersons(char firstLetter) {
        return dataGroups.getOrDefault(firstLetter, new MyList<>());
    }
}