package com.cap.apps.customerbootdatajparest.service;

import com.cap.apps.customerbootdatajparest.entities.Customer;

import java.util.List;

public interface CustomerService {
    public Customer register(Customer customer);
    public Customer updateName(Customer customer);
    public Customer findById(Long id);
    public void deleteById(Long id);
    public List<Customer> findAll();
    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    List<Customer> findByFullName(String firstName,String lastName);

}
