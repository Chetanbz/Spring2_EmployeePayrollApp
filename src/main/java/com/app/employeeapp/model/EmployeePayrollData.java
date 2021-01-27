package com.app.employeeapp.model;

import com.app.employeeapp.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(int i, EmployeePayrollDTO employeePayrollDTO) {
        super();
        this.employeeId = i;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }




}