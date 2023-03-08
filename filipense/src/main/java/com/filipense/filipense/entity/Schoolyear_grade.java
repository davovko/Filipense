package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "schoolyear_grade")
public class Schoolyear_grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schoolyear_grade_id;
    private int school_year;
    private int grade_id;
    public Schoolyear_grade(){
    }
    public int getSchoolyear_grade_id() {
        return schoolyear_grade_id;
    }

    public void setSchoolyear_grade_id(int schoolyear_grade_id) {
        this.schoolyear_grade_id = schoolyear_grade_id;
    }

    public int getSchool_year() {
        return school_year;
    }

    public void setSchool_year(int school_year) {
        this.school_year = school_year;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }
}
