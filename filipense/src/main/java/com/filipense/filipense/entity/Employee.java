package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private int person_id;
    private int employeetype_id;

    public Employee() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getEmployeetype_id() {
        return employeetype_id;
    }

    public void setEmployeetype_id(int employeetype_id) {
        this.employeetype_id = employeetype_id;
    }
}
