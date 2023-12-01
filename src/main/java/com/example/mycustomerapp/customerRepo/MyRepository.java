package com.example.mycustomerapp.customerRepo;

import com.example.mycustomerapp.dto.UpdateCustomerDto;
import com.example.mycustomerapp.exception.CustomerException;
import com.example.mycustomerapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface MyRepository {

    Customer saveCustomer(Customer customer);
    void deleteCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Optional<Customer> findCustomerById(Long id);


}
