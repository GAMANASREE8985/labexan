package com.klef.jfsd.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.exam.model.Customer;
import com.klef.jfsd.exam.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String updateCustomer(Customer customer) {
        try {
            if (customerRepository.existsById(customer.getId())) {
                customerRepository.save(customer);
                return "Customer updated successfully";
            } else {
                throw new Exception("Customer not found");
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
