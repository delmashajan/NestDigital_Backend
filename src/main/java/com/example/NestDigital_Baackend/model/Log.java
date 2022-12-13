package com.example.NestDigital_Baackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")

public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int empcode;
    private String checkIn;
    private int checkOut;
    private String inDate;
    private String outDate;

    public Log() {
    }

    public Log(int id, int empcode, String checkIn, int checkOut, String inDate, String outDate) {
        this.id = id;
        this.empcode = empcode;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.inDate = inDate;
        this.outDate = outDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }
}
