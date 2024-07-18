package com.example.SpringBoot.REST.API.Controller;


import com.example.SpringBoot.REST.API.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

//    @GetMapping(path ="/getMessage")
//    public String getMessage(){
//        return "Hi from Controller";
//    }

    @GetMapping(path="/employees/{employeeId}")
    public EmployeeDTO  getEmployeeById(@PathVariable Long employeeId){
            return new EmployeeDTO(employeeId, "Rushi","rushi@gmail.com",23);

    @GetMapping(path="/employee")
            public String getAllEmployee(){
                return "HI";
        }


    }
}
