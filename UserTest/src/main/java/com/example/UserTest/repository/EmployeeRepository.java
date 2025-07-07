package com.example.UserTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.UserTest.model.Employee;

import jakarta.persistence.Id;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByEmpname(String empname);

    @Query(value="select e from Employee e where e.supervisor=:supervisor order by e.eid asc")
    public List<Employee> findBySupervisor(String supervisor);

    @Modifying
    @Query(value="update Employee e set e.empname=:empname, e.designation=:designation,e.supervisor=:supervisor where e.eid=:eid")
    public int updateEmployee(String empname, String designation, String supervisor, long eid);
    
}
