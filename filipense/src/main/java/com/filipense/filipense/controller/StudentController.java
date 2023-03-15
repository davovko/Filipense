package com.filipense.filipense.controller;

import com.filipense.filipense.entity.StudentPerson;
import com.filipense.filipense.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentPerson/{student_id}")
    public ResponseEntity<StudentPerson> getStudentPerson(@PathVariable("student_id") int student_id) {
        return new ResponseEntity<>(studentService.getStudentPerson(student_id), HttpStatus.OK);
    }
}
