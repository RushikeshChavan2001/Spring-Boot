package com.example.SpringBoot.REST.API.Controller;


import com.example.SpringBoot.REST.API.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;



@RestController

public class EmployeeController {

    @GetMapping(path ="/getMessage")
    public String getMessage(){
        return "Hi from Controller";
    }

    @GetMapping(path="/employees/{employeeId}")
    public EmployeeDTO  getEmployeeById(@PathVariable Long employeeId){
            return new EmployeeDTO(employeeId, "Rushi","rushi@gmail.com",23);

    }

    @GetMapping(path ="/getEmployeeById")
    public String getEmployeeById(@RequestParam (required = false) Integer age , @RequestParam (required = false) String name){
        return "Hi from Controller" +age +"  "+ name;
    }

    @PostMapping(path ="/PostMapping")
    public String DisplayString(){
        return "hi from PostMapping";
    }


    @PostMapping(path ="/PostMappingJson")
    public EmployeeDTO CreateEmp(@RequestBody EmployeeDTO InputEmployee){
        InputEmployee.setId(100L);
        return InputEmployee;
    }

    @PutMapping(path="/PutMapping")
    public String getPutMapping(){
        return "hello from putMapping";
    }
}
