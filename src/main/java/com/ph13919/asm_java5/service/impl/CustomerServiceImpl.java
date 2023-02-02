package com.ph13919.asm_java5.service.impl;

import com.ph13919.asm_java5.entity.Customer;
import com.ph13919.asm_java5.repository.CustomerRepo;
import com.ph13919.asm_java5.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl  implements CustomerService {

    public final CustomerRepo customerRepo;
    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();

    }

    @Override
    public List<Customer> searchByCode(String code) {
        return customerRepo.findCustomersByCodeContaining(code);
    }

    @Override
    public void add(Customer customer) {
customerRepo.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.save(customer);

    }

    @Override
    public Customer getById(Integer id) {
        Optional<Customer> optional = customerRepo.findById(id);
        Customer customer = null;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" Customer not found for id :: " + id);
        }
        return customer;
    }
    @Override
    public Customer getByCode(String code) {
        Optional<Customer> optional = Optional.ofNullable(customerRepo.findCustomerByCode(code));
        Customer customer = null;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" Customer not found for code :: " + code);
        }
        return customer;
    }

    @Override
    public void delete(Integer id) {
        this.customerRepo.deleteById(id);
    }
}
