package com.filipense.filipense.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentPerson {
    private int person_id;
    private int identification_type_Id;
    private String identification_number;
    private String first_name;
    private String middle_name = null;
    private String last_name;
    private String second_last_name = null;
    private int person_type_id;
    private LocalDate date_of_birth;
    private String email;
    private LocalDateTime creation_date = LocalDateTime.now();
    private int creation_user_id;
    private LocalDateTime modification_date = null;
    private Integer modification_user_id = null;
    private boolean status;
    private int student_id;
    private int schoolyear_grade_id;
    private String student_code;
    private int user_id;
    private int dependency_id;
    public StudentPerson() {
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getIdentification_type_Id() {
        return identification_type_Id;
    }

    public void setIdentification_type_Id(int identification_type_Id) {
        this.identification_type_Id = identification_type_Id;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_last_name() {
        return second_last_name;
    }

    public void setSecond_last_name(String second_last_name) {
        this.second_last_name = second_last_name;
    }

    public int getPerson_type_id() {
        return person_type_id;
    }

    public void setPerson_type_id(int person_type_id) {
        this.person_type_id = person_type_id;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public int getCreation_user_id() {
        return creation_user_id;
    }

    public void setCreation_user_id(int creation_user_id) {
        this.creation_user_id = creation_user_id;
    }

    public LocalDateTime getModification_date() {
        return modification_date;
    }

    public void setModification_date(LocalDateTime modification_date) {
        this.modification_date = modification_date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSchoolyear_grade_id() {
        return schoolyear_grade_id;
    }

    public void setSchoolyear_grade_id(int schoolyear_grade_id) {
        this.schoolyear_grade_id = schoolyear_grade_id;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public Integer getModification_user_id() {
        return modification_user_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setModification_user_id(Integer modification_user_id) {
        this.modification_user_id = modification_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDependency_id() {
        return dependency_id;
    }

    public void setDependency_id(int dependency_id) {
        this.dependency_id = dependency_id;
    }
}
