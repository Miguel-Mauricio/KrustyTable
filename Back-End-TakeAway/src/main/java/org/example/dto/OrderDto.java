package org.example.dto;


import org.example.model.Food;

import javax.validation.constraints.*;

public class OrderDto {


    private Integer id;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private  String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    @Size(min = 9, max = 16)
    private String phone;

    private Food food;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
