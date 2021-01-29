package com.app.employeeapp.services;

import java.util.ArrayList;
import java.util.List;

import com.app.employeeapp.dto.EmployeePayrollDTO;
import com.app.employeeapp.exception.EmployeePayrollException;
import com.app.employeeapp.model.EmployeePayrollData;

import com.app.employeeapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    private List<EmployeePayrollData> empdataList = new ArrayList<>();


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository.
                findById(empId).
                orElseThrow(()-> new EmployeePayrollException("Employee with empId "+empId+" does not exists"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData( employeePayrollDTO); ///new object created
        log.debug("Emp Data: "+empData.toString());
        empdataList.add(empData);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(employeePayrollData);
    }

    @Override
    public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
        return employeePayrollRepository.findEmployeeByDepartment(department);
    }
}