package com.kaushik.bookstore.service;

import com.kaushik.bookstore.model.Purchase;
import com.kaushik.bookstore.model.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
