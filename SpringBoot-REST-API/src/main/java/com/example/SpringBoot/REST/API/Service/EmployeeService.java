package com.example.SpringBoot.REST.API.Service;

import com.example.SpringBoot.REST.API.Configuration.ModelConfig;
import com.example.SpringBoot.REST.API.DTO.EmployeeDTO;
import com.example.SpringBoot.REST.API.Entity.EmployeeEntity;
import com.example.SpringBoot.REST.API.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


//All the business logic should be written in Service package
// Service layer is act as a bridge between presentation layer(Controller) snd Persistence Layer (Repository)

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper=modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long employeeId){
        EmployeeEntity employeeEntity=  employeeRepository.findById(employeeId).orElse(null);

        return modelMapper.map(employeeEntity ,EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
      return  employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)).collect(Collectors.toList());
    }


    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee){
        EmployeeEntity toSaveEntity=modelMapper.map(inputEmployee,EmployeeEntity.class);
        EmployeeEntity saveEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(saveEmployeeEntity, EmployeeDTO.class);
    }



}
