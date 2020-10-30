package com.cap.apps.customerbootjparest.repository;

import com.cap.apps.customerbootjparest.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    public Customer add(Customer customer);
    public Customer update(Customer customer);
    public Customer findById(Long id);
    public Customer deleteById(Long id);
    public List<Customer> findAll();

 }
