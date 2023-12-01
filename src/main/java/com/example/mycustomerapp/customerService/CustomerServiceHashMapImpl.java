package com.example.mycustomerapp.customerService;

import com.example.mycustomerapp.dto.CustomerDto;
import com.example.mycustomerapp.dto.UpdateCustomerDto;
import com.example.mycustomerapp.exception.CustomerException;
import com.example.mycustomerapp.model.Customer;

import java.util.List;

public class CustomerServiceHashMapImpl implements CustomerServiceDb{


    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) throws CustomerException {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }

    @Override
    public Customer getCustomer(Long id) throws CustomerException {
        return null;
    }

    @Override
    public UpdateCustomerDto updateCustomer(Long id, UpdateCustomerDto updateCustomerDto) throws CustomerException {
        return null;
    }

    @Override
    public void deleteCustomer(Customer customer) throws CustomerException {

    }
}
