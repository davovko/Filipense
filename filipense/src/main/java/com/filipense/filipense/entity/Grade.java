package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grade_id;
    private String description;

    public Grade() {
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
