package com.app.employeeapp.repository;

import com.app.employeeapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface EmployeePayrollRepository  extends JpaRepository<EmployeePayrollData,Integer> {
    @Query(value = "select * from employee_payroll,employee_department where employee_id=id and department=:department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeeByDepartment(String department);
}
