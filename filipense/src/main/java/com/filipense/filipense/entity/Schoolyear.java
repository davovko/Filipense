package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "schoolyear")
public class Schoolyear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schoolyear_id;
    private String year;

    public Schoolyear() {
    }

    public int getSchoolyear_id() {
        return schoolyear_id;
    }

    public void setSchoolyear_id(int schoolyear_id) {
        this.schoolyear_id = schoolyear_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
