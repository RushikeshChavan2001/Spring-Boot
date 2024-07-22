package com.example.SpringBoot.REST.API.Service;

import com.example.SpringBoot.REST.API.Configuration.ModelConfig;
import com.example.SpringBoot.REST.API.DTO.EmployeeDTO;
import com.example.SpringBoot.REST.API.Entity.EmployeeEntity;
import com.example.SpringBoot.REST.API.Repository.EmployeeRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


//All the business logic should be written in Service package
// Service layer is act as a bridge between presentation layer(Controller) snd Persistence Layer (Repository)

@Service
@Getter
@Setter

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper=modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long employeeId){

       // EmployeeEntity employeeEntity=  employeeRepository.findById(employeeId).orElse(null);

        return employeeRepository.findById(employeeId).map(employeeEntity ->modelMapper.map(employeeEntity ,EmployeeDTO.class));
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


    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity= modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity= employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);

    }


    public boolean isExistById(Long employeeId){
       return  employeeRepository.existsById(employeeId);
    }



    public String DeleteEmployeeById(Long employeeId) {
        boolean exist = isExistById(employeeId);

        if(!exist){return "Employee With the ID "+ employeeId+" does not exist";
        }else {
            employeeRepository.deleteById(employeeId);
            return "Employee with ID "+ employeeId +" Deleted Succesfully";
        }


    }

    public String  deleteAllEmployee() {
        employeeRepository.deleteAll();
        return "delete";
    }


    public EmployeeDTO PartiallyUpdateEmployeeById(Long employeeId, Map<String, Object> update) {

        boolean exist =isExistById(employeeId);

        if(!exist)return  null;
         EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
         update.forEach((field,value) ->{
             Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class , field);
             fieldToBeUpdated.setAccessible(true);
             ReflectionUtils.setField(fieldToBeUpdated , employeeEntity, value);
         });
         return modelMapper.map(employeeRepository.save(employeeEntity) ,EmployeeDTO.class);
        }


    }

