package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "reason")
public class Reason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reason_id;
    private int dependency_id;
    private String description;

    public Reason() {
    }

    public int getReason_id() {
        return reason_id;
    }

    public void setReason_id(int reason_id) {
        this.reason_id = reason_id;
    }

    public int getDependency_id() {
        return dependency_id;
    }

    public void setDependency_id(int dependency_id) {
        this.dependency_id = dependency_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
