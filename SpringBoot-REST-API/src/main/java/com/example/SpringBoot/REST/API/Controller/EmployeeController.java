package com.example.SpringBoot.REST.API.Controller;


import com.example.SpringBoot.REST.API.DTO.EmployeeDTO;
import com.example.SpringBoot.REST.API.Entity.EmployeeEntity;
import com.example.SpringBoot.REST.API.Repository.EmployeeRepository;
import com.example.SpringBoot.REST.API.Service.EmployeeService;
import io.micrometer.observation.ObservationFilter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }


//    @GetMapping(path ="/getMessage")
//    public String getMessage(){
//        return "Hi from Controller";
//    }

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
    public ResponseEntity<EmployeeDTO>  getEmployeeById(@PathVariable(name="employeeId") Long employeeId){
        Optional<EmployeeDTO> employeeDTO =  employeeService.getEmployeeById(employeeId);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestParam (required = false) Integer age , @RequestParam (required = false) String name){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
       EmployeeDTO savedEmployee  = employeeService.createNewEmployee(inputEmployee);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path="/{employeeId}")
    public ResponseEntity<String> DeleteEmployeeById(@PathVariable Long employeeId ){

       String deleteResponse= employeeService.DeleteEmployeeById(employeeId);
        return  ResponseEntity.ok(deleteResponse);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployee(){
       String DeleteAllResponse= employeeService.deleteAllEmployee();
        return ResponseEntity.ok(DeleteAllResponse);
    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> PartiallyUpdateEmployeeById(@RequestBody Map<String ,Object> update , @PathVariable Long employeeId){
        EmployeeDTO employeeDTO= employeeService.PartiallyUpdateEmployeeById(employeeId, update);
        if(employeeDTO == null) return  ResponseEntity.notFound().build();
        return
                ResponseEntity.ok(employeeDTO);
    }




}
