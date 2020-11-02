package com.cap.apps.customerbootdatajparest;

import com.cap.apps.customerbootdatajparest.entities.Customer;
import com.cap.apps.customerbootdatajparest.exceptions.CustomerNameException;
import com.cap.apps.customerbootdatajparest.exceptions.CustomerNotExistException;
import com.cap.apps.customerbootdatajparest.service.CustomerService;
import com.cap.apps.customerbootdatajparest.service.CustomerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(CustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerServiceImplTest {

	@Autowired
	CustomerService service;

	@Autowired
	private EntityManager entityManager;

	/**
	 * case: customer is successfully added in store
	 */
	@Test
	public void testRegister_1(){
		String firstName="saksham", lastName="khanna";
		Customer customer=new Customer(firstName,lastName);
		customer=service.register(customer);
		TypedQuery<Customer>query= entityManager.createQuery("from Customer",Customer.class);
		List<Customer>list=query.getResultList();
		Assertions.assertEquals(1,list.size());
		Customer stored=list.get(0);
		Assertions.assertEquals(customer.getId(),stored.getId());
		Assertions.assertEquals(firstName,stored.getFirstName());
		Assertions.assertEquals(lastName,stored.getLastName());

	}

	/**
	 * scenario: customer object is null
	 */
	@Test
	public void testRegister_2(){
		Customer customer=null;
		Executable executable=()-> service.register(customer);
		Assertions.assertThrows(CustomerNotExistException.class,executable);
	}

	/**
	 * scenario: when firstname is empty
	 */
	@Test
	public void testRegister_3(){
		String firstName="", lastName="khanna";

		Customer customer=new Customer(firstName,lastName);
		Executable executable=()-> service.register(customer);
		Assertions.assertThrows(CustomerNameException.class,executable);
	}

	/**
	 * scenerio: customer exists in the store
	 * precondition: customer  added to the store
	 */
	@Test
	public void testFindById_1(){
		String firstName="saksham", lastName="khanna";
		Customer customer=new Customer(firstName,lastName);
		entityManager.persist(customer);
		Long id=customer.getId();
		Customer result=service.findById(id);
		Assertions.assertEquals(id,result.getId());
		Assertions.assertEquals(firstName,result.getFirstName());
		Assertions.assertEquals(lastName,result.getLastName());

	}

	/**
	 * scaberio: customer not there in store
	 */
	@Test
	public void testFindById_2(){
		Executable executable=()->service.findById(23l);
		Assertions.assertThrows(CustomerNotExistException.class,executable);
	}


}
