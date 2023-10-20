package org.fubar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PersonAgeDataGroups {
    private final Map<Integer, List<Person>> dataGroups;

    public PersonAgeDataGroups() {
        dataGroups = new HashMap<>();
    }

    public void addPerson(Person person) {
        int age = person.age();
        List<Person> groupData = dataGroups.getOrDefault(age, new ArrayList<>());
        groupData.add(person);
        dataGroups.put(age, groupData);
    }

    public List<Person> getPersons(int age) {
        return dataGroups.getOrDefault(age, new ArrayList<>());
    }
}