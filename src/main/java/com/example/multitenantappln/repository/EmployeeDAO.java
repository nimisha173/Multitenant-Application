package com.example.multitenantappln.repository;

import com.example.multitenantappln.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
    List<Employee> findAll();                           // fetch all Employee
}
