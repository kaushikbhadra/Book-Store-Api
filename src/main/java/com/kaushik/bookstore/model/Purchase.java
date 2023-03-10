package com.kaushik.bookstore.model;

import com.kaushik.bookstore.entity.Address;
import com.kaushik.bookstore.entity.Customer;
import com.kaushik.bookstore.entity.MyOrder;
import com.kaushik.bookstore.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private MyOrder order;
    private Set<OrderItem> orderItems = new HashSet<>();
}
