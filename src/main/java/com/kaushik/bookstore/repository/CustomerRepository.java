package com.kaushik.bookstore.repository;

import com.kaushik.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
