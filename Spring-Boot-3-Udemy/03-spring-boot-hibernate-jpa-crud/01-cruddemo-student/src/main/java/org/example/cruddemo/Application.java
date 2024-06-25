package org.example.cruddemo;

import org.example.cruddemo.dao.StudentDAO;
import org.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // executed after the Spring Beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);

            // createMultipleStudents(studentDAO);

            // readStudent(studentDAO, 4);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO,"Doe");

            // updateStudent(studentDAO);

            // deleteStudent(studentDAO);

            deleteAllStudents(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ... ");
        Student tempStudent = new Student("John", "Doe", "paul@luv2code.com");

        // save the student object.
        System.out.println("Saving student ... ");
        studentDAO.save(tempStudent);

        // display id of the saved student.
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 students objects ... ");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Bontia", "Applebum", "bontia@luv2code.com");

        // save the student objects
        System.out.println("Saving the students ... ");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void readStudent(StudentDAO studentDAO, int id) {

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + id);
        Student myStudent = studentDAO.findById(id);
        System.out.println(myStudent == null ? "No student found" : "Found the student " + myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO, String theLastName) {
        List<Student> theStudents = studentDAO.findByLastName(theLastName);

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student base on the id: primary key
        int updateStudentId = 1;
        System.out.println("Getting student with id: " + updateStudentId);
        Student myStudent = studentDAO.findById(updateStudentId);

        // change first name to "Scooby"
        System.out.println("Updating student ... ");
        myStudent.setFirstName("Aya");
        studentDAO.update(myStudent);

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }
}
