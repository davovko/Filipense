package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "identificationtype")
public class IdentificationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificationtype_id;
    private String description;

    public IdentificationType() {
    }

    public int getIdentificationtype_id() {
        return identificationtype_id;
    }

    public void setIdentificationtype_id(int identificationtype_id) {
        this.identificationtype_id = identificationtype_id;
    }
}
