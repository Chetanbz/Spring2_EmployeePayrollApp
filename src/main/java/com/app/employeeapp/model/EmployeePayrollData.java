package com.app.employeeapp.model;

import com.app.employeeapp.dto.EmployeePayrollDTO;
import lombok.Data;

public @Data class EmployeePayrollData {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(int i, EmployeePayrollDTO employeePayrollDTO) {
        super();
        this.employeeId = i;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

}