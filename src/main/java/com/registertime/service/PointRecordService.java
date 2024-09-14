package com.registertime.service;

import com.registertime.dto.PointRecordDto;
import com.registertime.model.PointRecord;
import com.registertime.repository.PointRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class PointRecordService implements Serializable {

    @Autowired
    private PointRecordRepository repository;

    @Transactional
    public PointRecordDto savePointRecord(PointRecordDto dto){
        PointRecord pointRecord = new PointRecord();
        pointRecord.setInstant(Instant.now());
        pointRecord.setType(dto.getType());
        pointRecord.setEmployee(dto.getEmployeeId());
        pointRecord = repository.save(pointRecord);
        return new PointRecordDto(pointRecord);
    }
}
