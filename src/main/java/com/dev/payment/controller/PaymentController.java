package com.dev.payment.controller;

import com.dev.payment.dto.PaymentRequest;
import com.dev.payment.dto.Response;
import com.dev.payment.service.interf.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Response> createPayment(@RequestBody PaymentRequest paymentRequest) throws Exception {

        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }

}
