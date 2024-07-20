package com.example.SpringBoot.REST.API.Controller;


import com.example.SpringBoot.REST.API.DTO.EmployeeDTO;
import com.example.SpringBoot.REST.API.Entity.EmployeeEntity;
import com.example.SpringBoot.REST.API.Repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/employee")
public class EmployeeController {


   private final EmployeeRepository employeeRepository;

   public EmployeeController(EmployeeRepository employeeRepository){
       this.employeeRepository=employeeRepository;
   }






    @GetMapping(path ="/getMessage")
    public String getMessage(){
        return "Hi from Controller";
    }

//    @GetMapping(path="/employees/{employeeId}")
//    public EmployeeDTO  getEmployeeById(@PathVariable Long employeeId){
//            return new EmployeeDTO(employeeId, "Rushi","rushi@gmail.com",23);
//
//    }


//
//    @GetMapping(path ="/getEmployeeById")
//    public String getEmployeeById(@RequestParam (required = false) Integer age , @RequestParam (required = false) String name){
//        return "Hi from Controller" +age +"  "+ name;
//    }
//
//    @PostMapping(path ="/PostMapping")
//    public String DisplayString(){
//        return "hi from PostMapping";
//    }
//
//
//    @PostMapping(path ="/PostMappingJson")
//    public EmployeeDTO CreateEmp(@RequestBody EmployeeDTO InputEmployee){
//        InputEmployee.setId(100L);
//        return InputEmployee;
//    }
//
//    @PutMapping(path="/PutMapping")
//    public String getPutMapping(){
//        return "hello from putMapping";
//    }














    @GetMapping(path="/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long employeeId){
        return employeeRepository.findById(employeeId).orElse(null);
    }


    @GetMapping
    public List<EmployeeEntity> getEmployeeById(@RequestParam (required = false) Integer age , @RequestParam (required = false) String name){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity CreateEmploye(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }
    
    @PutMapping(path="/PutMapping")
    public String getPutMapping(){
        return "hello from putMapping";
    }
}
