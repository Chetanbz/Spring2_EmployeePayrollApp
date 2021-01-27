package com.app.employeeapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public @ToString class  EmployeePayrollDTO {

    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name Invalid")
    public String name;

    @Min(value = 500,message = "Min Wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern ="dd MMM yyyy")
    @NotNull(message ="StartDate should not be Empty")
    @PastOrPresent(message = "Start Dat should not be past or today")
    public LocalDate startDate;

    @NotNull(message ="note should not be Empty")
    public String note;

    @NotNull(message ="message should not be Empty")
    public String profilePic;

    @NotNull(message ="SDepartment should not be Empty")
    public List<String> department;


}