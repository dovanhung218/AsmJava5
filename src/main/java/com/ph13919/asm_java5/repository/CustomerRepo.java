package com.ph13919.asm_java5.repository;

import com.ph13919.asm_java5.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findCustomerByCode(String code);
    List<Customer> findCustomersByCodeContaining(String code);
}
