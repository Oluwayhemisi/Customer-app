package com.example.mycustomerapp.customerService;

import com.example.mycustomerapp.customerRepo.CustomerRepository;
import com.example.mycustomerapp.customerRepo.MyRepository;
import com.example.mycustomerapp.dto.CustomerDto;
import com.example.mycustomerapp.dto.UpdateCustomerDto;
import com.example.mycustomerapp.exception.CustomerException;
import com.example.mycustomerapp.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;
import java.util.List;

public class CustomerServiceDbImpl implements CustomerServiceDb {
    private final MyRepository customerRepository;

    private ModelMapper modelMapper;

    public CustomerServiceDbImpl(@Qualifier(value = "customerRepository") MyRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }


    public CustomerDto addCustomer(CustomerDto customerDto) throws CustomerException {
        if(customerRepository.findCustomerById(customerDto.getId()).isPresent()){
        throw new CustomerException("Customer Id Exist",404);
     }
      Customer customer = new Customer();

       customer.setFullName(customerDto.getFullName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
       customer.setDateJoined(LocalDate.now());
       Customer customer1 = customerRepository.saveCustomer(customer);
       return modelMapper.map(customer1,CustomerDto.class);
        }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public Customer getCustomer(Long id) throws CustomerException {
       Customer customer = customerRepository.findCustomerById(id).orElseThrow(()-> new CustomerException("Customer Id Does Not Exist",404));
        return customer;
    }

    @Override
    public UpdateCustomerDto updateCustomer(Long id, UpdateCustomerDto updateCustomerDto) throws CustomerException {
        Customer customer = customerRepository.findCustomerById(id).orElseThrow(()-> new CustomerException("Customer Id Does Not Exist",404));
        Customer savedCustomer = modelMapper.map(updateCustomerDto,Customer.class);
        customer.setFullName(updateCustomerDto.getFullName());
        customer.setPhoneNumber(updateCustomerDto.getPhoneNumber());
        customer.setDateJoined(customer.getDateJoined());
        customerRepository.saveCustomer(customer);
        return modelMapper.map(savedCustomer,UpdateCustomerDto.class);

    }

    @Override
    public void deleteCustomer(Customer customer) throws CustomerException {
        Customer customer1 = customerRepository.findCustomerById(customer.getId()).orElseThrow(()-> new CustomerException("Customer Id Does Not Exist",404));
        customerRepository.deleteCustomer(customer1);
    }


}



