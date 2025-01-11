package org.example.controller;

import org.example.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private final StudentService studentService;
    Scanner sc = new Scanner(System.in);

    public StudentController(){
        this.studentService = new StudentService();
    }

    public void run(){
        studentService.loadStudentsFromFile();
        while (true) {
            System.out.println("\n Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option 1-6: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1-> studentService.addStudent();
                case 2-> studentService.updateStudent();
                case 3-> studentService.deleteStudent();
                case 4-> studentService.viewAllStudents();
                case 5-> studentService.searchStudent();
                case 6-> {
                    studentService.saveStudentsToFile();
                    System.out.println("Exiting the program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please choose between 1-6");

            }
        }
    }

}
