package com.filipense.filipense.service;

import com.filipense.filipense.components.Validations;
import com.filipense.filipense.entity.*;
import com.filipense.filipense.repository.PersonRepository;
import com.filipense.filipense.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<StudentPerson> listStudents(int student_id) {
        return null;
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
