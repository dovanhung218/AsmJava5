package com.ph13919.asm_java5.service;

import com.ph13919.asm_java5.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    List<Customer> searchByCode(String code);
    void add(Customer customer);

    void update(Customer customer);
    Customer getById(Integer id);
    Customer getByCode(String code);
    void delete(Integer id);
}
