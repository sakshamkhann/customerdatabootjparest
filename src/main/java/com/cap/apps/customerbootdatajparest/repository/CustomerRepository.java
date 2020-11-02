package com.cap.apps.customerbootdatajparest.repository;

import com.cap.apps.customerbootdatajparest.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
      List<Customer> findByFirstName(String firstName);

      List<Customer> findByLastName(String LastName);

      @Query("from Customer where firstName=:fname and lastName=:lname")
      List<Customer> findByFullName(@Param("fname") String firstName, @Param("lname") String lastName);


 }
