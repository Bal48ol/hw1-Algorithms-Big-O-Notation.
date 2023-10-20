package org.fubar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class PersonNameDataGroup {
    private final Map<Character, List<Person>> dataGroups;

    public PersonNameDataGroup() {
        dataGroups = new HashMap<>();
    }

    public void addPerson(Person person) {
        char firstLetter = person.lastName().charAt(0);
        List<Person> groupData = dataGroups.getOrDefault(firstLetter, new ArrayList<>());
        groupData.add(person);
        dataGroups.put(firstLetter, groupData);
    }

    public List<Person> getPersons(char firstLetter) {
        return dataGroups.getOrDefault(firstLetter, new ArrayList<>());
    }
}