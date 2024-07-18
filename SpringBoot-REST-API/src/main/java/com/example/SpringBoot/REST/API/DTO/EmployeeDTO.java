package com.example.SpringBoot.REST.API.DTO;


import java.time.LocalDate;
import java.time.LocalDateTime;

//data Transfer Object
public class EmployeeDTO {




//
//    private Long id;
//    private  String name;
//
//    public EmployeeDTO(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }









   private Long id;
   private String name;

    private String email;

    private  Integer age;
  //  private LocalDateTime dateofJoinning;

   // private boolean isActive;

//    public EmployeeDTO() {
//    }
//
//    public EmployeeDTO(Long id, String name, String email, Integer age,  Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        //this.dateofJoinning = dateofJoinning;
//        this.isActive = isActive;
//    }

    public EmployeeDTO(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

//    public EmployeeDTO(Long employeeId, String rushi, String s, int i) {
//
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public LocalDateTime getDateofJoinning() {
//        return dateofJoinning;
//    }
//
//    public void setDateofJoinning(LocalDateTime dateofJoinning) {
//        this.dateofJoinning = dateofJoinning;
//    }

//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        this.isActive = active;
//    }
}
