package com.tbsq.api.automation.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDetail {
    private String company;
    private String address;
    private List<EmployeeDetail> employeeDetails = null;
}
