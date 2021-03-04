package com.example.api.controller;

public class Employee {
    private String Name;
    private String Designation;
    private String EmpId;
    private int Salary;

    public void setName(String name) {
        Name = name;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public void setEmpId(String empId) {
        EmpId = empId;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getName() {
        return Name;
    }

    public int getSalary() {
        return Salary;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getEmpId() {
        return EmpId;
    }

    public Employee() {
    }
}
