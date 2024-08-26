package com.example.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int numberofappointment;

    public int getNumberofappointment() {
        return numberofappointment;
    }

    public void setNumberofappointment(int numberofappointment) {
        this.numberofappointment = numberofappointment;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}