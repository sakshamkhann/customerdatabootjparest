package com.cap.apps.customerbootjparest.dto;

public class CreateCustomerRequest {
    private String name;

    public CreateCustomerRequest(){

    }

    public CreateCustomerRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
