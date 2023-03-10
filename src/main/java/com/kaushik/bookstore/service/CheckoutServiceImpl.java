package com.kaushik.bookstore.service;

import com.kaushik.bookstore.entity.Customer;
import com.kaushik.bookstore.entity.MyOrder;
import com.kaushik.bookstore.entity.OrderItem;
import com.kaushik.bookstore.model.Purchase;
import com.kaushik.bookstore.model.PurchaseResponse;
import com.kaushik.bookstore.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        MyOrder order = purchase.getOrder();
        String orderTrackNumber = generateTN();
        order.setOrderTrackingNumber(orderTrackNumber);
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());
        Customer customer = purchase.getCustomer();
        customer.add(order);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackNumber);
    }

    private String generateTN() {
        return UUID.randomUUID().toString();
    }
}
