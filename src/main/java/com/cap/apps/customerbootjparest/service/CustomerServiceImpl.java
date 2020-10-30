package com.cap.apps.customerbootjparest.service;

import com.cap.apps.customerbootjparest.entities.Customer;
import com.cap.apps.customerbootjparest.repository.CustomerRepository;
import com.cap.apps.customerbootjparest.util.ValidateCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public Customer register(Customer customer) {
        ValidateCustomer.checkName(customer.getName());
        repo.add(customer);
        return customer;
    }


    @Override
    public Customer updateName(Customer customer)  {
        ValidateCustomer.checkName(customer.getName());
        ValidateCustomer.checkId(customer.getId());
        Customer customerFind = findById(customer.getId());
        ValidateCustomer.checkCustomerExist(customerFind);
        customerFind.setName(customer.getName());
        repo.update(customerFind);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = repo.findById(id);
        ValidateCustomer.checkCustomerExist(customer);
        return customer;
    }

    @Override
    public Customer deleteById(Long id) {
        Customer customer = repo.deleteById(id);
        ValidateCustomer.checkCustomerExist(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = repo.findAll();
        return list;
    }
    /*public Customer checkExists(Customer customer){
        try{
        ValidateCustomer.checkCustomerExist(customer);
        }
        catch (CustomerNotExistException e){
            Customer newCustomer = new Customer();
            return newCustomer;
        }
        return customer;
    }*/


}
