package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "dependency")
public class Dependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dependency_id;
    private String dependency_name;

    public Dependency() {
    }

    public int getDependency_id() {
        return dependency_id;
    }

    public void setDependency_id(int dependency_id) {
        this.dependency_id = dependency_id;
    }

    public String getDependency_name() {
        return dependency_name;
    }

    public void setDependency_name(String dependency_name) {
        this.dependency_name = dependency_name;
    }
}
