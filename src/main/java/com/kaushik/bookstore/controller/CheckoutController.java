package com.kaushik.bookstore.controller;

import com.kaushik.bookstore.model.Purchase;
import com.kaushik.bookstore.model.PurchaseResponse;
import com.kaushik.bookstore.service.CheckoutService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/checkout")
@AllArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(
        name = "Checkout Order",
        description = "Here, POST all details of orders due to purchase endpoint."
)
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    PurchaseResponse placeOrder(@Valid @RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
