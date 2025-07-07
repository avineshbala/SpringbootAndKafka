package com.example.UserTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.UserTest.model.Employee;
import com.example.UserTest.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository <Salary, Long>{

    @Modifying
    @Query(value = "update Salary s set s.salary=:salary where s.eid=:eid")
    public int updateSalary(int salary, long eid);
    
      
    
}
