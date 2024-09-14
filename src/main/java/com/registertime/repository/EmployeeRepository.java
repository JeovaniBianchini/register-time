package com.registertime.repository;

import com.registertime.model.Employee;
import com.registertime.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tb_employee.email AS username, tb_employee.password FROM tb_employee
            WHERE tb_employee.email = :email""")
    List<UserDetailsProjection> searchUserByEmail(String email);
}
