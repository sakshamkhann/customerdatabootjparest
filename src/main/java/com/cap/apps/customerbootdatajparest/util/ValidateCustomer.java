package com.cap.apps.customerbootdatajparest.util;

import com.cap.apps.customerbootdatajparest.entities.Customer;
import com.cap.apps.customerbootdatajparest.exceptions.CustomerIdException;
import com.cap.apps.customerbootdatajparest.exceptions.CustomerNameException;
import com.cap.apps.customerbootdatajparest.exceptions.CustomerNotExistException;

public class ValidateCustomer {
    public static void  checkName(String name){
        if( name==null || name.isEmpty())
        {
            throw new CustomerNameException("name is not valid");
        }
    }

    public static void  checkId(Long Id){
        if(Id==null)
        {
            throw new CustomerIdException("Id is not valid");
        }
    }

    public static void  checkCustomerExist(Customer customer){
        if(customer==null)
        {
            throw new CustomerNotExistException("customer is not existing");
        }
    }
}
