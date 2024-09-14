package com.registertime.service;

import com.registertime.dto.EmployeeDto;
import com.registertime.model.Employee;
import com.registertime.projections.UserDetailsProjection;
import com.registertime.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional
    public EmployeeDto saveEmployee(EmployeeDto dto){
        Employee employee = new Employee();
        BeanUtils.copyProperties(dto, employee);
        employee = repository.save(employee);
        return new EmployeeDto(employee);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> result = repository.searchUserByEmail(username);
        if (result.size() == 0) {
            throw new UsernameNotFoundException("User not found");
        }

        Employee employee = new Employee();
        employee.setEmail(username);
        employee.setPassword(result.get(0).password());

        return employee;
    }
}
