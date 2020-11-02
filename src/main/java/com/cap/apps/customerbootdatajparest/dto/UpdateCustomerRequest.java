package com.cap.apps.customerbootdatajparest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateCustomerRequest {
    @NotBlank
    @Size(min=2, max=10)
    private String firstName;

    @NotBlank @Size(min=2, max=10)
    private  String lastName;

    private Long id;

    public UpdateCustomerRequest(){

    }


    public UpdateCustomerRequest(String firstName, String lastName, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
