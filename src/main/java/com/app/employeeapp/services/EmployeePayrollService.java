package com.app.employeeapp.services;

import java.util.ArrayList;
import java.util.List;

import com.app.employeeapp.dto.EmployeePayrollDTO;
import com.app.employeeapp.exception.EmployeePayrollException;
import com.app.employeeapp.model.EmployeePayrollData;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollData> empdataList = new ArrayList<>();


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return empdataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return empdataList.stream()
                .filter(empData -> empData.getEmployeeId() == empId)
                .findFirst()
                .orElseThrow(() ->new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData( employeePayrollDTO);
        empdataList.add(empData);
        return empData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        empdataList.set(empId - 1, empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        empdataList.remove(empId - 1);
    }
}