package com.example.NestDigital_Baackend.dao;

import com.example.NestDigital_Baackend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
