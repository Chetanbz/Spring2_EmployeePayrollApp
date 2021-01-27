package com.app.employeeapp.services;

import java.util.List;

import com.app.employeeapp.dto.EmployeePayrollDTO;
import com.app.employeeapp.model.EmployeePayrollData;


public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);


    void deleteEmployeePayrollData(int empId);
    List<EmployeePayrollData> getEmployeeByDepartment(String department);



}