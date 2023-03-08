package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    private int person_id;
    private int schoolyear_grade_id;
    private String student_code;
    public Student(){
    }
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
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
}
