package com.example.mycustomerapp.customerService;

import com.example.mycustomerapp.dto.CustomerDto;
import com.example.mycustomerapp.dto.UpdateCustomerDto;
import com.example.mycustomerapp.exception.CustomerException;
import com.example.mycustomerapp.model.Customer;

import java.util.List;

public interface CustomerServiceDb {

    CustomerDto addCustomer(CustomerDto customerDto) throws CustomerException;

    List<Customer> getAllCustomer();

    Customer getCustomer(Long id) throws CustomerException;

    UpdateCustomerDto updateCustomer(Long id, UpdateCustomerDto updateCustomerDto) throws CustomerException;

    void deleteCustomer(Customer customer) throws CustomerException;

}
