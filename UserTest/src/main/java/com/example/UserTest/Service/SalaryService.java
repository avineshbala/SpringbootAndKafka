package com.example.UserTest.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserTest.model.Employee;
import com.example.UserTest.model.Salary;
import com.example.UserTest.repository.SalaryRepository;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class SalaryService {
@Autowired
public SalaryRepository salaryrepo;

public List<Salary> saveSalary(List<Salary> salaryReq){
      return salaryrepo.saveAll(salaryReq);
}

@Transactional
public int updateSalary(Salary updateSal){
      return salaryrepo.updateSalary(updateSal.getSalary(),updateSal.getEid());
}

@Transactional(TxType.REQUIRES_NEW)
public int updateSalaryForEid(int salary, long eid){
      return salaryrepo.updateSalary(salary,eid);
}

}
