package com.filipense.filipense.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String password;
    private int person_id;
    private int dependency_id;
    private String username;
    public User(){
    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getDependency_id() {
        return dependency_id;
    }

    public void setDependency_id(int dependency_id) {
        this.dependency_id = dependency_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
