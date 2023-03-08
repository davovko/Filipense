package com.filipense.filipense.controller;

import com.filipense.filipense.service.ObservationService;
import com.filipense.filipense.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;


}
