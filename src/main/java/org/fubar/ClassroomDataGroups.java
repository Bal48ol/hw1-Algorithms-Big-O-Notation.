package org.fubar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ClassroomDataGroups {
    private final Map<String, List<Person>> dataGroups;

    public ClassroomDataGroups() {
        dataGroups = new HashMap<>();
    }

    public void addPerson(Person person) {
        String group = String.valueOf(person.group());
        List<Person> groupData = dataGroups.getOrDefault(group, new ArrayList<>());
        groupData.add(person);
        dataGroups.put(group, groupData);
    }

    public List<Person> getPersons(String group) {
        return dataGroups.getOrDefault(group, new ArrayList<>());
    }
}
