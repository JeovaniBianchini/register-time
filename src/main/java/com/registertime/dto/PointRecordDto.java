package com.registertime.dto;

import com.registertime.model.Employee;
import com.registertime.model.PointRecord;
import com.registertime.model.Type;

import java.time.Instant;

public class PointRecordDto {

    private Instant instant;
    private Type type;
    private Employee employeeId;

    public PointRecordDto(){
    }

    public PointRecordDto(Instant instant, Type type, Employee employeeId) {
        this.instant = instant;
        this.type = type;
        this.employeeId = employeeId;
    }

    public PointRecordDto(PointRecord pointRecord) {
        instant = pointRecord.getInstant();
        type = pointRecord.getType();
        employeeId = pointRecord.getEmployee();
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }
}
