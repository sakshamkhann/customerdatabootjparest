package com.cap.apps.customerbootdatajparest.service;

import com.cap.apps.customerbootdatajparest.entities.Customer;
import com.cap.apps.customerbootdatajparest.exceptions.CustomerNotExistException;
import com.cap.apps.customerbootdatajparest.repository.CustomerRepository;
import com.cap.apps.customerbootdatajparest.util.ValidateCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    private static final Logger Log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public Customer register(Customer customer) {
        ValidateCustomer.checkCustomerExist(customer);
        ValidateCustomer.checkName(customer.getFirstName());
        ValidateCustomer.checkName(customer.getLastName());
        repo.save(customer);
        return customer;
    }


    @Override
    public Customer updateName(Customer customer)  {
        ValidateCustomer.checkName(customer.getFirstName());
        ValidateCustomer.checkName(customer.getLastName());
        ValidateCustomer.checkId(customer.getId());
        Customer customerFind = findById(customer.getId());
        customerFind.setFirstName(customer.getFirstName());
        customerFind.setLastName(customer.getLastName());
        repo.save(customerFind);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        ValidateCustomer.checkId(id);
        Optional<Customer> optional = repo.findById(id);
        if(!optional.isPresent()){
            throw new CustomerNotExistException("customer not found");
        }
        Customer customer = optional.get();
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        ValidateCustomer.checkId(id);
        repo.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = repo.findAll();
        return list;
    }

    @Override
    public List<Customer> findByFirstName(String firstName) {
        ValidateCustomer.checkName(firstName);
        List<Customer> list = repo.findByFirstName(firstName);
        return list;
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        ValidateCustomer.checkName(lastName);
        List<Customer> list = repo.findByLastName(lastName);
        return list;
    }

    @Override
    public List<Customer> findByFullName(String firstName, String lastName) {
        ValidateCustomer.checkName(firstName);
        ValidateCustomer.checkName(lastName);
        List<Customer> list = repo.findByFullName(firstName, lastName);
        return list;
    }


}
