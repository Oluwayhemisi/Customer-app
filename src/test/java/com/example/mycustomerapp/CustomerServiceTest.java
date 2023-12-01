package com.example.mycustomerapp;

import com.example.mycustomerapp.customerRepo.CustomerHashMap;
import com.example.mycustomerapp.customerRepo.CustomerRepository;
import com.example.mycustomerapp.customerRepo.MyRepository;
import com.example.mycustomerapp.customerService.CustomerServiceDb;
import com.example.mycustomerapp.customerService.CustomerServiceDbImpl;
import com.example.mycustomerapp.dto.CustomerDto;
import com.example.mycustomerapp.exception.CustomerException;
import com.example.mycustomerapp.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {


    private CustomerRepository customerRepository;
    private final MyRepository myRepository = mock(CustomerRepository.class);

    private final ModelMapper modelMapper = mock(ModelMapper.class);
    CustomerServiceDb customerServiceDb;



    @BeforeEach
    void setUp(){
        customerServiceDb = new CustomerServiceDbImpl(myRepository, modelMapper);

    }


    @Test
    void testToCheckThatTheMethodWasCalled() throws CustomerException {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFullName("yuhij");
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName("erruyiy");
        when(myRepository.saveCustomer(isA(Customer.class))).thenReturn(customer);
        customerServiceDb.addCustomer(customerDto);
        verify(myRepository, times(1)).saveCustomer(isA(Customer.class));

    }
    @Test
    void testToAddCustomer() throws CustomerException {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFullName("yuhij");
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1L);
        customerDto.setFullName("yuhij");

        when(myRepository.saveCustomer(isA(Customer.class))).thenReturn(customer);
       CustomerDto result = customerServiceDb.addCustomer(customerDto);
        assertEquals(customer,customerDto);
    }

//    @Test
//    void testToGetCustomers() throws CustomerException {
//        Customer customer = new Customer();
//        customer.setId(1L);
//        customer.setPhoneNumber("dfghjk");
//        customer.setFullName("ityuioi");
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setFullName("ityuioi");
//        customerDto.setPhoneNumber("dfghjk");
//        when(myRepository.saveCustomer(customer)).thenReturn(customer);

//        List<Customer> customer = new ArrayList<>();
//        customer.add(new Customer(1L,"tryu","yuwyy",LocalDate.now()));
//        customer.add(new Customer(2L, "hjskds","83723",LocalDate.now()));
//
//        when(customerServiceDb.getAllCustomer()).thenReturn(customer);
//    }

//    @Test
//    void testToCheck(){
//       Customer customer = new Customer(1L,"tryu","yuwyy",LocalDate.now());
//       assertThat(customer.getFullName()).isNotEmpty();
//
//    }



}
