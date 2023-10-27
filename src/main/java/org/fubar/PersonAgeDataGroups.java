package org.fubar;

class PersonAgeDataGroups {
    private final MyMap<Integer, MyList<Person>> dataGroups;

    public PersonAgeDataGroups() {
        dataGroups = new MyMap<>();
    }

    public void addPerson(Person person) {
        int age = person.age();
        MyList<Person> groupData = dataGroups.getOrDefault(age, new MyList<>());
        groupData.add(person);
        dataGroups.put(age, groupData);
    }

    public MyList<Person> getPersons(int age) {
        return dataGroups.getOrDefault(age, new MyList<>());
    }
}