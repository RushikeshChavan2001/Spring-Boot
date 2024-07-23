package com.example.SpringBoot.REST.API.DTO;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//data Transfer Object
@NoArgsConstructor
@Getter
@Setter

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

   @NotBlank(message = "Name should be entered")
   @Size(min =3, max=10,  message = "Name should be in the char between 3 to 10")
   private String name;

   @Email(message ="Please enter Valid email")
    private String email;


   @Max(value= 80, message="age should be less than 80")
   @Min(value =20 ,message = "age should be greater than 20")
    private  Integer age;

   @NotBlank
   @Pattern(regexp= "^(ADMIN|USER)$", message = "Role can only be ADMIN or USER")
   private String role;

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

    public EmployeeDTO(Long id, String name, String email, Integer age, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.role = role;
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
