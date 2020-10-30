package com.cap.apps.customerbootjparest.controllers;


import com.cap.apps.customerbootjparest.dto.CreateCustomerRequest;
import com.cap.apps.customerbootjparest.dto.CustomerDetails;
import com.cap.apps.customerbootjparest.dto.UpdateCustomerRequest;
import com.cap.apps.customerbootjparest.entities.Customer;
import com.cap.apps.customerbootjparest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerDetails> findAll(){
        List<Customer> list = service.findAll();
        List<CustomerDetails> response = list.stream().map(customer -> getCustomerDetail(customer)).collect(Collectors.toList());
        return response;
    }

    @GetMapping("findBy/{id}")
    public CustomerDetails findBy(@PathVariable("id") Long id){
        Customer customer = service.findById(id);
        CustomerDetails customerDetails = getCustomerDetail(customer);
        return customerDetails;
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails addCustomer(@RequestBody CreateCustomerRequest request){
        Customer customer = new Customer(request.getName());
        customer = service.register(customer);
        CustomerDetails customerDetails = getCustomerDetail(customer);
        return customerDetails;
    }

    @PutMapping("/update")
    public CustomerDetails updateCustomer(@RequestBody UpdateCustomerRequest request){
         Customer customer = new Customer(request.getName());
         customer.setId(request.getId());
         customer = service.updateName(customer);
         CustomerDetails customerDetails = getCustomerDetail(customer);
         return customerDetails;
    }

    @DeleteMapping("/remove/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        Customer customer = service.findById(id);
        service.deleteById(id);
        String response = "customer with id deleted " + id;
        return response;
    }



    public CustomerDetails getCustomerDetail(Customer customer){
        CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getName());
        return customerDetails;
    }



}
