package com.company;

import java.util.Scanner;

/**
 * Created by sayla on 12/06/2016.
 */
public class University {
    private Scanner input = new Scanner(System.in);
    private int teacherIndex = 0;
    private Teacher[] teachers = new Teacher[10];

    public void welcome() {
        int choice;
        do {
            System.out.println("\nWelcome to University Management System");
            System.out.println("1. Add teacher");
            System.out.println("2. View teachers");
            System.out.println("3. Search a teacher");
            System.out.println("4. Update a teacher");
            System.out.println("5. Delete a teacher");
            System.out.println("Please enter your choice or press 0 to exit...");

            choice = input.nextInt();

            operate(choice);
        }while(choice != 0);
    }

    private void operate(int choice) {
        switch (choice) {
            case 1:
                addTeacher();
                viewTeachers();
                break;

            case 2:
                viewTeachers();
                break;

            case 3:
                searchTeacher();
                break;

            case 4:
                updateTeacher();
                break;

            case 5:
                deleteTeacher();
                break;
        }
    }

    private void deleteTeacher() {
        System.out.println("Enter the name of teacher: ");
        String name = input.next();

        removeTeacherFromData(name);
    }

    private void updateTeacher() {
        System.out.println("Enter the name of teacher to be updated: ");
        String oldName = input.next();

        int index = findTeacherInData(oldName);

        if(index >= 0) {
            System.out.println("Enter new name of teacher: ");
            String newName = input.next();

            updateTeacherInData(index, newName);
        }
        else {
            System.out.println(oldName + " is not found");
        }
    }

    private void searchTeacher() {
        System.out.println("Enter the name of teacher: ");
        String name = input.next();

        int index = findTeacherInData(name);

        if( index >= 0 ) {
            System.out.println("Name\tAge");
            displayTeacher(teachers[index]);
        }
        else {
            System.out.println(name + " is not found");
        }
    }

    private void viewTeachers() {
        if(teacherIndex < 1) {
            System.out.println("\nTeachers list in empty");
        }
        else {
            System.out.println("\nList of teachers:");
            System.out.println("Name\tAge");
            for (int i = 0; i < teacherIndex; i++) {
                displayTeacher(teachers[i]);
            }
        }
    }

    private void addTeacher() {
        Teacher t = new Teacher();

        System.out.println("Enter name: ");
        String name = input.next();
        t.setName(name);

        System.out.println("Enter age: ");
        int age = input.nextInt();
        t.setAge(age);

        saveTeacherToData(t);
    }

    private void displayTeacher(Teacher t) {
        System.out.println(t.getName() + "\t" + t.getAge());
    }

    private void saveTeacherToData(Teacher t) {
        teachers[teacherIndex++] = t;
    }

    private int findTeacherInData(String name) {
        for (int i = 0; i < teacherIndex; i++) {
            if(teachers[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void removeTeacherFromData(String name) {
        int index = findTeacherInData(name);

        for(int i = index; i < teacherIndex-1; i++ ) {
            teachers[i] = teachers[i+1];
        }
        System.out.println("Deleted");
        teacherIndex--;
    }

    private void updateTeacherInData(int index, String newName) {
        teachers[index].setName(newName);
        System.out.println("Updated");
    }

    public void initialize() {
        Teacher t = new Teacher();
        t.setName("Hassan");
        t.setAge(15);
        teachers[teacherIndex++] = t;

        t = new Teacher();
        t.setName("Waqas");
        t.setAge(20);
        teachers[teacherIndex++] = t;
    }
}