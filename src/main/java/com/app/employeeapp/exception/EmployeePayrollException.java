package com.app.employeeapp.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

public class EmployeePayrollException extends RuntimeException{
    public EmployeePayrollException(String message){
        super(message);
    }
}