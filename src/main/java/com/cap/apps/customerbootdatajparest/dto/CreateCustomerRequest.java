package com.cap.apps.customerbootdatajparest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateCustomerRequest {

    @NotBlank
    @Size(min=2, max=10)
    private String firstName;

    @NotBlank @Size(min=2, max=10)
    private  String lastName;

    public CreateCustomerRequest(){

    }

    public CreateCustomerRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
