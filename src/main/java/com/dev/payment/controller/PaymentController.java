package com.dev.payment.controller;

import com.dev.payment.dto.PaymentRequest;
import com.dev.payment.dto.Response;
import com.dev.payment.service.interf.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("")
    public ResponseEntity<Response> createPayment(@RequestBody PaymentRequest paymentRequest, BindingResult result) throws Exception {
        // Check if the invoice is invalid (empty or null)
        if (!paymentRequest.hasInvoices()) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .status(400)
                    .message("Invoices is required!")
                    .build());
        }

        // Process the payment request
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }
}
