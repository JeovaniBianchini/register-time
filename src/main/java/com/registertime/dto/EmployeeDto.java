package com.registertime.dto;

import com.registertime.model.Employee;

public class EmployeeDto {

    private Long id;
    private String name;

    public EmployeeDto(){
    }

    public EmployeeDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EmployeeDto(Employee employee) {
        name = employee.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
