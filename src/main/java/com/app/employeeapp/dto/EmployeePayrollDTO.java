package com.app.employeeapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name Invalid")
    public String name;

    @Min(value = 500,message = "Min Wage should be more than 500")
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