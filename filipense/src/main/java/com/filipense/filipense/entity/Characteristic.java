package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "characteristic")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characteristic_id;
    private String description;

    public Characteristic() {
    }

    public int getCharacteristic_id() {
        return characteristic_id;
    }

    public void setCharacteristic_id(int characteristic_id) {
        this.characteristic_id = characteristic_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
