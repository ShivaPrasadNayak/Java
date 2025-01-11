import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<Student>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadStudentsFromFile();
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
                case 1-> addStudent();
                case 2-> updateStudent();
                case 3-> deleteStudent();
                case 4-> viewAllStudents();
                case 5-> searchStudent();
                case 6-> {
                    saveStudentsToFile();
                    System.out.println("Exiting the program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please choose between 1-6");

            }
        }

    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter student grade: ");
        String grade = sc.nextLine();

        students.add(new Student(id, name, age, grade));
        System.out.println("Student added successfully");
    }

    private static void updateStudent() {
        System.out.println("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student student : students){
            if (student.getId() == id){
                System.out.print("Enter new student name: ");
                String name = sc.nextLine();
                System.out.print("Enter new student age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter new student grade: ");
                String grade = sc.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                System.out.println("Student updated successfully");
                return;
            }
        }
    }

    private static void deleteStudent() {
        System.out.println("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student student : students){
            if (student.getId() == id){
                students.remove(student);
                System.out.println("Student deleted successfully");
                return;
            }
        }
    }

    private static void viewAllStudents() {
        if(students.isEmpty()){
            System.out.println("No students found");
            return;
        }
        for (Student student : students){
            student.display();
        }
    }

    private static void searchStudent() {
        System.out.println("Enter student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student student : students){
            if (student.getId() == id){
                student.display();
                return;
            }
        }
        System.out.println("Student not found");
    }

    public static void saveStudentsToFile() {
        // Save students to a file
        try(FileWriter writer = new FileWriter("students.txt")){
            for (Student student : students){
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getGrade() + "\n");
            }
            System.out.println("Students saved to file successfully");
        }catch (Exception e){
            System.out.println("Error saving students to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void loadStudentsFromFile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String grade = data[3];
                students.add(new Student(id, name, age, grade));
            }
            System.out.println("Students loaded from file successfully");
        }catch (Exception e) {
            System.out.println("No previous data found. Starting fresh. " + e.getMessage());
            e.printStackTrace();
        }
    }

}