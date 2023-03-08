package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "employeetype")
public class EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeType_id;
    private String description;

    public EmployeeType() {
    }

    public int getEmployeeType_id() {
        return employeeType_id;
    }

    public void setEmployeeType_id(int employeeType_id) {
        this.employeeType_id = employeeType_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
