package com.example.UserTest.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.UserTest.model.Employee;
import com.example.UserTest.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
@Autowired
public EmployeeRepository empRepo;

public List<Employee> getAllEmployees(){
        return empRepo.findAll();
}

public List<Employee> findByEmployeeName(String empName){
        return empRepo.findByEmpname(empName);
}

public List<Employee> findBySupervisor(String supervisor){
        return empRepo.findBySupervisor(supervisor);
}
public List<Employee> addEmployee(List<Employee> employeeReq){
        ArrayList<Employee> emp = new ArrayList<Employee>();
        for (Employee employee : employeeReq) {
                Employee empAdd = empRepo.save(employee);
                emp.add(empAdd);
        }
        return emp;
}

public Page<Employee> findAllEmployees(){
        Pageable page = PageRequest.of(1,10,Sort.by("empname"));
        return empRepo.findAll(page);
}

@Transactional
public int updateEmployee(Employee updateEmployee){
        return empRepo.updateEmployee(updateEmployee.getEmpname(),updateEmployee.getDesignation(),updateEmployee.getSupervisor(),updateEmployee.getEid());
}

}
