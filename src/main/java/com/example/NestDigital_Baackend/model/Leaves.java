package com.example.NestDigital_Baackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "leaves")

public class Leaves {

    @Id
    @GeneratedValue

    private int id;
    private int empcode;
    private String type;
    private String description;
    private String applyDate;
    private String leaveDate;
    private int status;

    public Leaves() {
    }

    public Leaves(int id, int empcode, String type, String description, String applyDate, String leaveDate, int status) {
        this.id = id;
        this.empcode = empcode;
        this.type = type;
        this.description = description;
        this.applyDate = applyDate;
        this.leaveDate = leaveDate;
        this.status = status;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
