package com.filipense.filipense.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "characterization")
public class Characterization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterization_id;
    private int characteristic_id;
    private int student_id;
    private boolean status;
    private int creation_user_id;
    private LocalDateTime creation_date = LocalDateTime.now();
    private LocalDateTime modification_date = null;
    private Integer modification_user_id;

    public Characterization() {
    }

    public int getCharacterization_id() {
        return characterization_id;
    }

    public void setCharacterization_id(int characterization_id) {
        this.characterization_id = characterization_id;
    }

    public int getCharacteristic_id() {
        return characteristic_id;
    }

    public void setCharacteristic_id(int characteristic_id) {
        this.characteristic_id = characteristic_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCreation_user_id() {
        return creation_user_id;
    }

    public void setCreation_user_id(int creation_user_id) {
        this.creation_user_id = creation_user_id;
    }

    public LocalDateTime getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDateTime getModification_date() {
        return modification_date;
    }

    public void setModification_date(LocalDateTime modification_date) {
        this.modification_date = modification_date;
    }
}
