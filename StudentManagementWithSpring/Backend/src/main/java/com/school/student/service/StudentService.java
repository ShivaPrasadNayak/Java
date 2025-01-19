package com.school.student.service;

import com.school.student.model.Student;
import org.springframework.stereotype.Service;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    private static final String FILE_PATH = "src/main/resources/students.txt";
    private final List<Student> students = new ArrayList<>();

    public StudentService() {
        loadStudentsFromFile();
    }

    public void addStudent(Student student){
        students.add(student);
        saveStudentsToFile();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(int id, Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setGrade(updatedStudent.getGrade());
                saveStudentsToFile();
                return;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        saveStudentsToFile();
    }

    private void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String grade = parts[3];
                students.add(new Student(id, name, age, grade));
            }
        } catch (IOException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
        }
    }

    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGrade() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }
}
