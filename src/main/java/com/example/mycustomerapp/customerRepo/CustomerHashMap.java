package com.example.mycustomerapp.customerRepo;


import com.example.mycustomerapp.customerRepo.MyRepository;
import com.example.mycustomerapp.dto.CustomerDto;
import com.example.mycustomerapp.dto.UpdateCustomerDto;
import com.example.mycustomerapp.exception.CustomerException;
import com.example.mycustomerapp.model.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


public class CustomerHashMap implements MyRepository {

    private static Map<Long, Customer> customerRepo = new HashMap<>();

    @Override
    public Customer saveCustomer(Customer customer) {
      return   customerRepo.put(customer.getId(), customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepo.remove(customer.getId());

    }

    @Override
    public List<Customer> getAllCustomer() {
        Collection<Customer> c = customerRepo.values();
        return c.stream().toList();
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return Optional.empty();
    }


//
//
//    @Override
//    public CustomerDto saveCustomer(CustomerDto customerDto) throws CustomerException {
//        if((customerRepo.containsKey(customerDto.getId()) )){
//            throw new CustomerException("Customer Id Exist",404);
//        }
//        for (Customer cu: customerRepo.values()) {
//            if (cu.getPhoneNumber().equals(customerDto.getPhoneNumber())){
//                throw new CustomerException("Customer Number exist", 404);
//            }
//        }
//        Customer customer = new Customer();
//        customer.setDateJoined(LocalDate.now());
//        customerRepo.put(customerDto.getId(), customer);
//        return customerDto;
//    }
//
//    @Override
//    public void deleteCustomer(Long id) throws CustomerException {
//        if(!customerRepo.containsKey(id)){
//            throw new CustomerException("Customer Id Does Not Exist",404);
//        }
//        else{
//            customerRepo.remove(id);
//        }
//
//    }
//
//    @Override
//    public List<Customer> getAllCustomer() {
//        return (List<Customer>) customerRepo.values();
//
//    }
//
//    @Override
//    public Customer findCustomerById(Long id) throws CustomerException {
//        if(!(customerRepo.containsKey(id))){
//            throw new CustomerException("Customer Id Does Not Exist",404);
//
//        }
//        return customerRepo.get(id);
//    }
//
//    @Override
//    public UpdateCustomerDto updateCustomer(Long id, UpdateCustomerDto updateCustomerDto) throws Throwable {
//        if(!(customerRepo.containsKey(id))){
//            throw new CustomerException("Customer Id Does Not Exist",404);
//        }
//        customerRepo.remove(id);
//        Customer customer = new Customer();
//        customer.setFullName(updateCustomerDto.getFullName());
//        customer.setPhoneNumber(updateCustomerDto.getPhoneNumber());
//        customerRepo.put(id,customer);
//        return updateCustomerDto;
//
//    }
}
