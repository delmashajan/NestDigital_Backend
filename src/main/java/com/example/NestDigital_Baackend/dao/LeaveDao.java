package com.example.NestDigital_Baackend.dao;

import com.example.NestDigital_Baackend.model.Leaves;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<Leaves,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaves` SET `status`= :status WHERE `id` = :id",nativeQuery = true)
    void updateById (@Param("status") Integer status ,@Param("id") Integer id);

    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`description`, l.`empcode`, l.`leave_date`, l.`status`, l.`type`,e.name,e.designation FROM `leaves` l JOIN employee e ON l.empcode=e.empcode WHERE `status` = 0",nativeQuery = true)
    List<Map<String,String>> viewAllLeaveBy();

    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`description`, l.`empcode`, l.`leave_date`, l.`status`, l.`type`, e.name,e.designation FROM `leaves` l JOIN employee e ON l.empcode=e.empcode WHERE l.empcode= :empcode",nativeQuery = true)
    List<Map<String,String>>viewLeaveById(@Param("empcode") Integer empcode);
}
