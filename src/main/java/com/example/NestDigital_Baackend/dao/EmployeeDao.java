package com.example.NestDigital_Baackend.dao;

import com.example.NestDigital_Baackend.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `empcode`, `name`, `password`, `phone`, `salary`, `username` FROM `employee` WHERE `username` = :username AND `password` = :password",nativeQuery = true)
    List<Employee> Loginemployee (@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT `id`, `designation`, `email`, `empcode`, `name`, `password`, `phone`, `salary`, `username` FROM `employee` WHERE `empcode`= :empcode",nativeQuery = true)
    List<Employee> Searchemployee (@Param("empcode") Integer empcode);

    @Modifying
    @Transactional

    @Query(value = "DELETE FROM `employee` WHERE `id` = :id",nativeQuery = true)
    void Deleteemployee(@Param("id") Integer id);

    @Query(value = "SELECT `id`, `designation`, `email`, `empcode`, `name`, `password`, `phone`, `salary`, `username` FROM `employee` WHERE `id` = :id",nativeQuery = true)
    List<Employee> Viewprofile(@Param("id") Integer id);

}
