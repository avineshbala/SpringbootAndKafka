package com.example.UserTest.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.UserTest.Bean.UserBean;
import com.example.UserTest.Exception.CustomException;
import com.example.UserTest.Service.Cache;
import com.example.UserTest.Service.CountryService;
import com.example.UserTest.Service.EmployeeSalaryService;
import com.example.UserTest.Service.EmployeeService;
import com.example.UserTest.Service.SalaryService;
import com.example.UserTest.Service.userService;
import com.example.UserTest.config.DBConfig;
import com.example.UserTest.model.Employee;
import com.example.UserTest.model.Salary;

import jakarta.validation.Valid;

@RestController



@RequestMapping("/user")
@RefreshScope
public class UserTestController {
    @Autowired
    userService uService;

    @Autowired
    CountryService countryService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DBConfig dbConfig;

    @Autowired
    Cache myCache;

    @Autowired
    EmployeeService empService;

    @Autowired
    SalaryService salaryService;

    @Autowired
    EmployeeSalaryService empsalaryService;

    @Value("${spring.datasource.url}")
    String dbUrl;

    @Value("${spring.datasource.username}")
    String uname;

    @Value("${spring.datasource.password}")
    String pwd;


    @RequestMapping(method = RequestMethod.GET, value="/getUser", produces = {"application/json"})
    public ArrayList<UserBean> getUser(){

        // HttpHeaders headers = new HttpHeaders();
         //headers.set("TokenId", UUID.randomUUID().toString());
        
        return uService.getUsersDetails();
    }

    @RequestMapping(method = RequestMethod.GET, value="/getUserDetails", produces = {"application/json"})
    public ResponseEntity<UserBean> getUserId(@RequestParam (name="id") int id){

        UserBean response = uService.getUsersDetailsById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.set("RiskScore", uService.getUsersDetailsRiskScore(response));
         
        return new ResponseEntity<UserBean>(response, headers, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.GET, value="/getUserName", produces = {"text/plain"})
        public String getUserName()
        {
            return "Avinesh";
        }

    @RequestMapping(method=RequestMethod.GET, value="/getCountries",produces = {"application/json"})
        public Object getCountries(){
            return countryService.getCountries();
        }

    
    @RequestMapping(method = RequestMethod.POST, value="/addUser", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<UserBean> requestEntity(@Valid @RequestBody UserBean request) throws CustomException{

        HttpHeaders headers = new HttpHeaders();
        //enum gender{Male,Female};
        
        boolean userExists = uService.validateUserExists(request.getName());
        if(userExists){
            throw new CustomException("This user already exists");
        }
  
        UserBean response = uService.AddUsersDetails(request);
        
     
        return new ResponseEntity<UserBean>(response, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/deleteUserById", produces = {"text/plain"})
    public String deleteUserId(@RequestParam (name="id") int id){

        String response = uService.deleteUsersDetailsById(id);         
        return response;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/getConfig", produces = {"text/plain"})
    public String showConfig() {
    
        
        return "Server Port: " + 
                "\n DB URL: " + dbUrl +
                "\n DB User Name: " + uname +
                "\n DB Password: " + pwd +
                "\n Cache Value: " + myCache.getFromCache();
    }

      @RequestMapping(method=RequestMethod.GET, value="/getAllEmployees", produces = {"application/json"})
      public List<com.example.UserTest.model.Employee> getAllEmployees() 
        {
            return empService.getAllEmployees();
        }

       @RequestMapping(method=RequestMethod.GET, value="/findByEmployeeName", produces = {"application/json"})
      public List<com.example.UserTest.model.Employee> getEmployeeByName(@RequestParam (name="empname") String empname) 
        {
            return empService.findByEmployeeName(empname);
        }

    @RequestMapping(method=RequestMethod.GET, value="/findBySupervisor", produces = {"application/json"})
      public List<com.example.UserTest.model.Employee> findBySupervisor(@RequestParam (name="supervisor") String supervisor) 
        {
            return empService.findBySupervisor(supervisor);
        }

   @RequestMapping(method=RequestMethod.POST, value="/addEmployee", produces = {"application/json"}, consumes = {"application/json"})
      public List<Employee> addEmployee(@RequestBody List<Employee> employee) 
        {             
            return empService.addEmployee(employee); 
 
        }

    @RequestMapping(method=RequestMethod.GET, value="/findAllEmployees", produces = {"application/json"})
      public Page<Employee> findAllEmployees() 
        {
            return empService.findAllEmployees();
        }

         @RequestMapping(method=RequestMethod.POST, value="/addSalary", produces = {"application/json"}, consumes = {"application/json"})
      public List<Salary> addSalary(@RequestBody List<Salary> salary) 
        {             
            return salaryService.saveSalary(salary); 
 
        }

    @RequestMapping(method=RequestMethod.POST, value="/updateSalary", produces = {"application/json"}, consumes = {"application/json"})
      public int updateSalary(@RequestBody Salary salary) 
        {             
            return salaryService.updateSalary(salary); 
 
        }

        @RequestMapping(method=RequestMethod.POST, value="/updateEmployee", produces = {"application/json"}, consumes = {"application/json"})
      public int updateEmployee(@RequestBody Employee emp) 
        {             
            return empService.updateEmployee(emp); 
 
        }

        @RequestMapping(method=RequestMethod.POST, value="/updateEmployeeSalary", produces = {"application/json"}, consumes = {"application/json"})
      public int updateEmployeeSalary(@RequestBody Employee emp) throws Exception 
        {             
            return empsalaryService.updateEmployeeAndSalaryDetails(emp); 
 
        }
}



