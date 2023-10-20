package org.fubar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassroomDataGroups classroomDataGroups = new ClassroomDataGroups();
        PersonAgeDataGroups personAgeDataGroups = new PersonAgeDataGroups();
        PersonNameDataGroup personNameDataGroup = new PersonNameDataGroup();

        Path path = Path.of("C:\\Users\\dayof\\IdeaProjects\\hw1\\src\\main\\resources\\students.csv");
        try (FileReader input = new FileReader(String.valueOf(path));
             BufferedReader reader = new BufferedReader(input);
             Scanner scanner = new Scanner(reader)) {

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(";");
                String lastName = fields[0];
                String firstName = fields[1];
                int age = Integer.parseInt(fields[2]);
                int group = Integer.parseInt(fields[3]);
                int physics = Integer.parseInt(fields[4]);
                int mathematics = Integer.parseInt(fields[5]);
                int rus = Integer.parseInt(fields[6]);
                int literature = Integer.parseInt(fields[7]);
                int geometry = Integer.parseInt(fields[8]);
                int informatics = Integer.parseInt(fields[9]);

                Person person = new Person(firstName, lastName, age, group, physics, mathematics, rus, literature, geometry, informatics);
                classroomDataGroups.addPerson(person);
                personAgeDataGroups.addPerson(person);
                personNameDataGroup.addPerson(person);
            }
        }

        // 1. Средняя оценка
        List<Person> TenClassStudents = classroomDataGroups.getPersons("10");
        List<Person> ElevenClassStudents = classroomDataGroups.getPersons("11");
        System.out.println("\nСредняя оценка в 10 классе: " +  averageMark(TenClassStudents));
        System.out.println("Средняя оценка в 11 классе: " +  averageMark(ElevenClassStudents));

        // 2. Поиск всех отличников старше 14
        List<Person> honorStudents = new ArrayList<>();
        for (int age = 15; age <= 100; age++) {
            List<Person> studentsOver14 = personAgeDataGroups.getPersons(age);
            for (Person student : studentsOver14) {
                if (student.physics() == 5 && student.mathematics() == 5 &&
                        student.rus() == 5 && student.literature() == 5 &&
                        student.geometry() == 5 && student.informatics() == 5) {
                    honorStudents.add(student);
                }
            }
        }
        System.out.println("\nОтличники старше 14 лет:");
        for (Person person : honorStudents) {
            System.out.println("\t" + person.lastName() + " " + person.firstName());
        }

        // 3. Поиск ученика по фамили
        try (Scanner scanner = new Scanner(System.in)){
            System.out.println("\nВведите фамилию ученика для получения информации: ");
            String lastName = scanner.nextLine();
            List<Person> studentsWithLastName = personNameDataGroup.getPersons(lastName.charAt(0));
            List<Person> matchingStudents = new ArrayList<>();
            for (Person student : studentsWithLastName) {
                if (student.lastName().equalsIgnoreCase(lastName)) {
                    matchingStudents.add(student);
                }
            }
            System.out.println("Результаты поиска:");
            for (Person student : matchingStudents) {
                System.out.println(student.lastName() + " " + student.firstName() +
                        ", возраст: " + student.age() + ", класс: " + student.group());
            }
        }
    }

    private static double averageMark(List<Person> ClassStudents){
        int totalMarks = 0;
        int totalStudents = 0;
        for (Person person : ClassStudents) {
            totalMarks += person.physics() + person.mathematics() + person.rus() +
                    person.literature() + person.geometry() + person.informatics();
            totalStudents++;
        }
        return (double) totalMarks / (6 * totalStudents);
    }
}