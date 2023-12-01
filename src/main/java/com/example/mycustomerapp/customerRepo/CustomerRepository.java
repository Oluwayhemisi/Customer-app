package com.example.mycustomerapp.customerRepo;

import com.example.mycustomerapp.dto.CustomerDto;
import com.example.mycustomerapp.dto.UpdateCustomerDto;
import com.example.mycustomerapp.exception.CustomerException;
import com.example.mycustomerapp.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class CustomerRepository implements MyRepository{
   private final JpaRepository<Customer, Long> jpaRepository;

    public CustomerRepository(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;

    }


    @Override
    public Customer saveCustomer(Customer customer)  {
        return jpaRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
       jpaRepository.delete(customer);

    }

    @Override
    public List<Customer> getAllCustomer() {
       return jpaRepository.findAll();
    }

    @Override
    public Optional <Customer> findCustomerById(Long id) {
        return  jpaRepository.findById(id);
    }


}
