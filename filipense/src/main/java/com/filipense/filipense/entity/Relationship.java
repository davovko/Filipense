package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "relationship")
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int relationship_id;
    private String description;

    public Relationship() {
    }

    public int getRelationship_id() {
        return relationship_id;
    }

    public void setRelationship_id(int relationship_id) {
        this.relationship_id = relationship_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
