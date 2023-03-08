package com.filipense.filipense.components;

import com.filipense.filipense.entity.Person;
import com.filipense.filipense.entity.Student;
import com.filipense.filipense.repository.PersonRepository;
import com.filipense.filipense.repository.StudentRepository;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@Component
public class Validations {

    PersonRepository personRepository;
    StudentRepository studentRepository;
    public boolean checkIdentificationNumber(String identification_number, int identification_type_Id, int person_id){
        boolean response = true;
        Person person = personRepository.findPersonByIdentificationNumber(identification_number, identification_type_Id);

        if(person != null){
            if(person_id == 0){
                response = false;
            }else if(person.getPerson_id() != person_id ){
                response = false;
            }
        }

        return response ;
    }

    public boolean checkEmail(String email, int person_id){
        boolean response = true;
        Person person = personRepository.findPersonByEmail(email);

        if(person != null){
            if(person_id == 0){
                response = false;
            } else if(person.getPerson_id() != person_id ){
                response = false;
            }
        }

        return response;
    }

    public boolean checkStudentByCode(String student_code, int person_id){
        boolean response = true;
        Student student = studentRepository.getStudentByCode(student_code);

        if(student != null){
            if(person_id == 0){
                response = false;
            } else if(student.getPerson_id() != person_id ){
                response = false;
            }
        }

        return response;
    }

    public boolean validEmail(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        return pattern.matcher(email).find();
    }



}
