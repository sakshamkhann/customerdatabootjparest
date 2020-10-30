package com.cap.apps.customerbootjparest.service;

import com.cap.apps.customerbootjparest.entities.Customer;

import java.util.List;

public interface CustomerService {
    public Customer register(Customer customer);
    public Customer updateName(Customer customer);
    public Customer findById(Long id);
    public Customer deleteById(Long id);
    public List<Customer> findAll();

}
