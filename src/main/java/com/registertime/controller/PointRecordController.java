package com.registertime.controller;

import com.registertime.dto.EmployeeDto;
import com.registertime.dto.PointRecordDto;
import com.registertime.service.PointRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/register")
public class PointRecordController {

    @Autowired
    private PointRecordService service;

    @PostMapping
    public ResponseEntity<PointRecordDto> savePointRecord(@RequestBody PointRecordDto pointRecordDto){
        PointRecordDto dto = service.savePointRecord(pointRecordDto);
        return ResponseEntity.created(URI.create("201")).body(dto);
    }

}
