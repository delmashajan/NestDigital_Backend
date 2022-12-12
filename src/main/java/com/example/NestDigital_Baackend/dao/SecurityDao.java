package com.example.NestDigital_Baackend.dao;

import com.example.NestDigital_Baackend.model.Security;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {

    @Query(value = "SELECT `id`, `email`, `name`, `password`, `phone`, `salary`, `seccode`, `username` FROM `secuirities` WHERE `seccode` = :seccode",nativeQuery = true)
    List<Security> Searchsecurity(@Param("seccode") Integer seccode);

    @Modifying
    @Transactional

    @Query(value = "DELETE FROM `secuirities` WHERE `id` = :id",nativeQuery = true)
    void Deletesecurity (@Param("id") Integer id);


}
