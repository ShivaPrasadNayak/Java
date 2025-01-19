package com.school.student.controller;

import com.school.student.model.Student;
import com.school.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added successfully";
    }
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents(); // Returns the list of students
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        studentService.updateStudent(id, updatedStudent);
        return "Student updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }


}
