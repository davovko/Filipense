package com.filipense.filipense.service;

import com.filipense.filipense.components.Validations;
import com.filipense.filipense.entity.*;
import com.filipense.filipense.repository.PersonRepository;
import com.filipense.filipense.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneId;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    Validations validations;

    @Override
    public Student createStudent(Person person, int schoolyear_grade_id, String student_code) {

        person.setPerson_id(0);
        String message = allValidations(person);
        message += !validations.checkStudentByCode(student_code.trim().toUpperCase(), person.getPerson_id())? "El código estudiantil digitado ya existe. " : "";

        if (message.isEmpty()){
            person.setIdentification_number(person.getIdentification_number().trim().toUpperCase());
            person.setFirst_name(person.getFirst_name().trim().toUpperCase());
            person.setMiddle_name(person.getMiddle_name() != null ? person.getMiddle_name().trim().toUpperCase() : null);
            person.setLast_name(person.getLast_name().trim().toUpperCase());
            person.setSecond_last_name(person.getSecond_last_name() != null ? person.getSecond_last_name().trim().toUpperCase() : null);
            person.setEmail(person.getEmail().trim().toLowerCase());

            personRepository.save(person);

            Student student = new Student();
            student.setPerson_id(person.getPerson_id());
            student.setStudent_code(student_code);
            student.setSchoolyear_grade_id(schoolyear_grade_id);

            return studentRepository.save(student);
        }

        throw new IllegalArgumentException(message);
    }

    @Override
    public Student updateStudent(Person person, int student_id, int schoolyear_grade_id, String student_code, User user) {

        String message = allValidations(person);
        message += !validations.checkStudentByCode(student_code.trim().toUpperCase(), person.getPerson_id())? "El código estudiantil digitado ya existe. " : "";

        if (message.isEmpty()){

            Optional<Person> oldPerson= personRepository.findById(person.getPerson_id());
            Person newPerson = oldPerson.get();

            newPerson.setIdentification_number(person.getIdentification_number().trim().toUpperCase());
            newPerson.setFirst_name(person.getFirst_name().trim().toUpperCase());
            newPerson.setMiddle_name(person.getMiddle_name() != null ? person.getMiddle_name().trim().toUpperCase() : null);
            newPerson.setLast_name(person.getLast_name().trim().toUpperCase());
            newPerson.setSecond_last_name(person.getSecond_last_name() != null ? person.getSecond_last_name().trim().toUpperCase() : null);
            newPerson.setEmail(person.getEmail().trim().toLowerCase());

            personRepository.save(newPerson);

            Optional<Student> oldStudent = studentRepository.findById(student_id);
            Student newStudent = oldStudent.get();

            newStudent.setPerson_id(person.getPerson_id());
            newStudent.setStudent_code(student_code);
            newStudent.setSchoolyear_grade_id(schoolyear_grade_id);

            return studentRepository.save(newStudent);
        }

        throw new IllegalArgumentException(message);
    }

    @Override
    public StudentPerson getStudentPerson(int student_id) {
        Object[][] student = studentRepository.getStudentPerson(student_id);
        StudentPerson studentPerson = studentPerson = new StudentPerson();;

        if (student.length > 0){
            studentPerson.setStudent_id(Integer.parseInt(student[0][0].toString()));
            studentPerson.setIdentification_type_Id((Integer) student[0][1]);
            studentPerson.setIdentification_number((String) student[0][2]);
            studentPerson.setFirst_name((String) student[0][3]);
            studentPerson.setMiddle_name((String) student[0][4]);
            studentPerson.setLast_name((String) student[0][5]);
            studentPerson.setSecond_last_name((String) student[0][6]);
            studentPerson.setPerson_type_id((Integer) student[0][7]);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            studentPerson.setDate_of_birth(LocalDate.parse(student[0][8].toString().substring(0,10), formatter));
            studentPerson.setEmail((String) student[0][9]);
            studentPerson.setCreation_date(LocalDate.parse(student[0][10].toString().substring(0,10), formatter).atStartOfDay());
            studentPerson.setCreation_user_id((Integer) student[0][11]);
            studentPerson.setModification_date(student[0][12] != null ? LocalDate.parse(student[0][12].toString().substring(0,10), formatter).atStartOfDay() : null);
            studentPerson.setModification_user_id((Integer) student[0][13]);
            studentPerson.setStatus(student[0][14].toString() == "1" ? true : false);
            studentPerson.setStudent_id((Integer) student[0][15]);
            studentPerson.setSchoolyear_grade_id((Integer) student[0][17]);
            studentPerson.setStudent_code((String) student[0][18]);
            studentPerson.setUser_id((Integer) student[0][19]);
            studentPerson.setDependency_id((Integer) student[0][20]);
        }

        return studentPerson;
    }

    @Override
    public String allValidations(Person person){
        boolean duplicateIdentification = validations.checkIdentificationNumber(person.getIdentification_number().trim().toUpperCase(), person.getIdentification_type_Id(), person.getPerson_id());
        boolean email = validations.checkEmail(person.getEmail().trim().toLowerCase(), person.getPerson_id());
        boolean validEmail = validations.validEmail(person.getEmail().trim());
        boolean validName = (person.getFirst_name().trim().length() >= 2 && person.getLast_name().trim().length() >= 2 ? true: false);


        String message = !duplicateIdentification ? "El número de identificación ya existe en la base de datos. ": "";
        message += !email ? "El email ya existe en la base de datos.": "";
        message += !validEmail ? "El email ingresado no tiene el formato válido.": "";
        message += !validName ? "La extensión del Primer Nombre y del Primer Apellido NO puede ser menor a 2 caracteres.": "";

        return message;
    }
}
