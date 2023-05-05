package com.kaushik.bookstore.model;

import com.kaushik.bookstore.entity.Address;
import com.kaushik.bookstore.entity.Customer;
import com.kaushik.bookstore.entity.MyOrder;
import com.kaushik.bookstore.entity.OrderItem;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @NotNull(message = "mention customer details")
    private Customer customer;
    @NotNull(message = "mention shippingAddress details")
    private Address shippingAddress;
    @NotNull(message = "mention billingAddress details")
    private Address billingAddress;
    @NotNull(message = "mention order details")
    private MyOrder order;
    @NotNull(message = "mention list of orderItems details")
    private Set<OrderItem> orderItems = new HashSet<>();
}
