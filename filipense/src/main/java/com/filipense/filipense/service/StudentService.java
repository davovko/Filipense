package com.filipense.filipense.service;

import com.filipense.filipense.entity.Person;
import com.filipense.filipense.entity.Student;
import com.filipense.filipense.entity.StudentPerson;
import com.filipense.filipense.entity.User;

import java.util.List;

public interface StudentService {
    public Student createStudent(Person person, int schoolyear_grade_id, String student_code );
    public Student updateStudent(Person person, int student_id, int schoolyear_grade_id, String student_code , User user );
    public List<StudentPerson> listStudents(int student_id);

    String allValidations(Person person);
}
