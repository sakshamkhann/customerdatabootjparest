package com.cap.apps.customerbootdatajparest.controllers;


import com.cap.apps.customerbootdatajparest.dto.CreateCustomerRequest;
import com.cap.apps.customerbootdatajparest.dto.CustomerDetails;
import com.cap.apps.customerbootdatajparest.dto.UpdateCustomerRequest;
import com.cap.apps.customerbootdatajparest.entities.Customer;
import com.cap.apps.customerbootdatajparest.service.CustomerService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;


@Validated
@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping()
    public List<CustomerDetails> findAll(){
        List<Customer> list = service.findAll();
        List<CustomerDetails> response = list.stream().map(customer -> getCustomerDetail(customer)).collect(Collectors.toList());
        return response;
    }

    @GetMapping("/findById/{id}")
    public CustomerDetails findBy(@PathVariable("id") @NotNull  Long id){
        Customer customer = service.findById(id);
        CustomerDetails customerDetails = getCustomerDetail(customer);
        return customerDetails;
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDetails addCustomer(@RequestBody @Valid CreateCustomerRequest request){
        Customer customer = new Customer(request.getFirstName(), request.getLastName() );
        customer = service.register(customer);
        CustomerDetails customerDetails = getCustomerDetail(customer);
        return customerDetails;
    }

    @PutMapping("/update")
    public CustomerDetails updateCustomer(@RequestBody @Valid UpdateCustomerRequest request){
         Customer customer = new Customer(request.getFirstName(), request.getLastName());
         customer.setId(request.getId());
         customer = service.updateName(customer);
         CustomerDetails customerDetails = getCustomerDetail(customer);
         return customerDetails;
    }

    @DeleteMapping("/remove/{id}")
    public String deleteCustomer(@PathVariable("id") @NotNull  Long id){
        Customer customer = service.findById(id);
        service.deleteById(id);
        String response = "customer with id deleted " + id;
        return response;
    }

    @GetMapping("/findBy/FirstName/{firstName}")
    public List<CustomerDetails> findByFirstName(@PathVariable("firstName") @NotBlank @Size(min=2, max=10) String firstName){
        List<Customer> listCustomer = service.findByFirstName(firstName);
        return listCustomer.stream().map(e->getCustomerDetail(e)).collect(Collectors.toList());
    }

    @GetMapping("/findBy/LastName/{lastName}")
    public List<CustomerDetails> findByLastName(@PathVariable("lastName") @NotBlank @Size(min=2, max=20) String lastName){
        List<Customer> listCustomer = service.findByLastName(lastName);
        return listCustomer.stream().map(e->getCustomerDetail(e)).collect(Collectors.toList());
    }

    @GetMapping("/findBy/fullName/{firstName}/{lastName}")
    public List<CustomerDetails> findByFullName(@PathVariable("firstName") @NotBlank @Size(min=2, max=10) String firstName, @PathVariable("lastName") @NotBlank @Size(min=2, max=10) String lastName){
        List<Customer> listCustomer = service.findByFullName(firstName, lastName);
        return listCustomer.stream().map(e->getCustomerDetail(e)).collect(Collectors.toList());
    }

    public CustomerDetails getCustomerDetail(Customer customer){
        CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getFirstName(), customer.getLastName());
        return customerDetails;
    }



}
