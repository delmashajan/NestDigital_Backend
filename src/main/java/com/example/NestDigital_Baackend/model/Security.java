package com.example.NestDigital_Baackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "secuirities")

public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private int seccode;
    private String name;

    private int salary;
    private String phone;
    private String email;
    private String username;
    private String password;

    public Security() {
    }

    public Security(int id, int seccode, String name, int salary, String phone, String email, String username, String password) {
        this.id = id;
        this.seccode = seccode;
        this.name = name;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeccode() {
        return seccode;
    }

    public void setSeccode(int seccode) {
        this.seccode = seccode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
