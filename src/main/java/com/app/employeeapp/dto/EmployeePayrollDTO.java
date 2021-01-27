package com.app.employeeapp.dto;

public class EmployeePayrollDTO {
    public String name;
    public long salary;


    public EmployeePayrollDTO(String name, long salary) {
        super();
        this.name = name;
        this.salary = salary;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name= " + name + ", salary= " + salary ;
    }



}