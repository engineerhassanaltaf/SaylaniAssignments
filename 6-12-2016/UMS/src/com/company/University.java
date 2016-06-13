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
        }
    }

    private void searchTeacher() {
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

        teachers[teacherIndex++] = t;
    }

    private void displayTeacher(Teacher t) {
        System.out.println(t.getName() + "\t" + t.getAge());
    }
}