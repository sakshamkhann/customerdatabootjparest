package com.cap.apps.customerbootjparest.repository;

import com.cap.apps.customerbootjparest.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer add(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
       entityManager.merge(customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Override
    public Customer deleteById(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
        return customer;

    }

    @Override
    public List<Customer> findAll() {
        String q = "from Customer";
            TypedQuery<Customer> query = entityManager.createQuery(q, Customer.class);
        List<Customer> list = query.getResultList();
        return list;
    }


}
