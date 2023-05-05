package com.kaushik.bookstore.controller;

import com.kaushik.bookstore.model.Purchase;
import com.kaushik.bookstore.model.PurchaseResponse;
import com.kaushik.bookstore.service.CheckoutService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
@AllArgsConstructor
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    PurchaseResponse placeOrder(@Valid @RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
