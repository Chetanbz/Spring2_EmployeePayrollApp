package com.app.employeeapp.services;

import java.util.ArrayList;
import java.util.List;

import com.app.employeeapp.dto.EmployeePayrollDTO;
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
        return empdataList.get(empId - 1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empdataList.size() + 1, employeePayrollDTO);
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