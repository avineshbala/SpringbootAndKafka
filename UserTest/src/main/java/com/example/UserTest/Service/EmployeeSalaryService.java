package com.example.UserTest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.UserTest.model.Employee;
import com.example.UserTest.repository.EmployeeRepository;
import com.example.UserTest.repository.SalaryRepository;

import jakarta.transaction.Transactional;

@Component
@Service

public class EmployeeSalaryService {

    @Autowired
    EmployeeRepository empRepo;
    @Autowired
    SalaryService salaryService;


    @Transactional(rollbackOn = Exception.class)
    public int updateEmployeeAndSalaryDetails (Employee e) throws Exception{

        int empResult = empRepo.updateEmployee(e.getEmpname(),e.getDesignation(),e.getSupervisor(),e.getEid());
        int salaryResult = salaryService.updateSalaryForEid(500000,e.getEid());
        if(e.getEid()==1)
            throw new Exception("Employee Not Found");

        return salaryResult;
        
    }


}
