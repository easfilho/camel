package com.poc.camel.domain;

public class Employee {
    private String id;
    private String name;
    private String joinDate;

    public Employee() {
    }

    public Employee(String id, String name, String joinDate) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name + "Join Date: " + joinDate;
    }
}
