package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "persontype")
public class PersonType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int persontype_id;
    private String description;

    public PersonType() {
    }

    public int getPersontype_id() {
        return persontype_id;
    }

    public void setPersontype_id(int persontype_id) {
        this.persontype_id = persontype_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
