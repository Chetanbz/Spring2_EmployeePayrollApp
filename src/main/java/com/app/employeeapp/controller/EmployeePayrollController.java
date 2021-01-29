package com.app.employeeapp.controller;


import com.app.employeeapp.dto.EmployeePayrollDTO;
import com.app.employeeapp.dto.ResponseDTO;
import com.app.employeeapp.model.EmployeePayrollData;
import com.app.employeeapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        System.out.println("Get,1");
        List<EmployeePayrollData> empdataList = null;
        empdataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", empdataList);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        System.out.println("Get,2");
        EmployeePayrollData empData =null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get call Sucess for Id:", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData( @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        System.out.println("post");
        EmployeePayrollData empData =null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data for: ", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData( @PathVariable("empId") int empId,
                                                                  @Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        System.out.println("Put");
        EmployeePayrollData empData =null;
        empData = employeePayrollService.updateEmployeePayrollData(empId,employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Update Employee Payroll Data for :", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        System.out.println("delete");
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Delete  Sucessfully :","Deleted Id: " + empId);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public  ResponseEntity<ResponseDTO> getEmployeeData(@PathVariable("department") String department){
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeeByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO("get call for department successfull " , empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
}