package pt.iade.unimanage.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.Student;
import pt.iade.unimanage.models.repositories.StudentRepository;
// test joao
@RestController
@RequestMapping(path="/api/students")
public class StudentController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        logger.info("Sending all students");
        return StudentRepository.getAllStudents();
    }

    // Get student with the student number and return it
    @GetMapping(path = "/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentByNumber(@PathVariable("number") int number) {
        logger.info("Sending student with number "+number);
        return StudentRepository.getStudent(number);
    }

    @DeleteMapping(path = "/{number}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Student deleteStudentByNumber(@PathVariable("number") int number) {
        logger.info("Deleting student with number "+number);
        Student student = StudentRepository.getStudent(number);
        logger.info("Adding second test");
        if (!StudentRepository.deleteStudent(number))
            logger.info("Student with number "+number+" does not exist");
        return student;
    }

}