package com.cap.apps.customerbootjparest.dto;

public class UpdateCustomerRequest {
    private String name;

    private Long id;

    public UpdateCustomerRequest(){

    }


    public UpdateCustomerRequest(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
