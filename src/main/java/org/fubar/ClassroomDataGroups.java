package org.fubar;

class ClassroomDataGroups {
    private final MyMap<String, MyList<Person>> dataGroups;

    public ClassroomDataGroups() {
        dataGroups = new MyMap<>();
    }

    public void addPerson(Person person) {
        String group = String.valueOf(person.group());
        MyList<Person> groupData = dataGroups.getOrDefault(group, new MyList<>());
        groupData.add(person);
        dataGroups.put(group, groupData);
    }

    public MyList<Person> getPersons(String group) {
        return dataGroups.getOrDefault(group, new MyList<>());
    }
}