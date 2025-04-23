package com.dev.payment.service.impl;
import java.util.List;
import java.util.Random;

import com.dev.payment.dto.InvoiceItem;
import com.dev.payment.dto.PaymentRequest;
import com.dev.payment.dto.PaymentResponse;
import com.dev.payment.dto.Response;
import com.dev.payment.entity.Payment;
import com.dev.payment.repository.PaymentRepository;
import com.dev.payment.security.AESUtil;
import com.dev.payment.service.interf.WebhookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.dev.payment.service.interf.PaymentService;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final WebhookService webhookService;

    @Override
    public Response createPayment(PaymentRequest paymentRequest) throws Exception {
        Payment payment = new Payment();
        payment.setEmail(paymentRequest.getEmail());
        payment.setCardNumber(AESUtil.encrypt(paymentRequest.getCardNumber()));
        payment.setExpiryDate(paymentRequest.getExpiryDate());
        payment.setCvc(paymentRequest.getCvc());
        payment.setCardHolderName(paymentRequest.getCardHolderName());
        payment.setCountry(paymentRequest.getCountry());
        payment.setZipCode(paymentRequest.getZipCode());
        payment.setInvoices(paymentRequest.getInvoices());
        payment.setAmount(paymentRequest.getAmount());
        payment.setRefNumber(generateRandomRefNumber());

        // Save new payment
        Payment saved = paymentRepository.save(payment);

        // Send new payment to all webhooks
        webhookService.sendToAllWebhook(saved);

        // Set the data to respond
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setRefNumber(saved.getRefNumber());
        paymentResponse.setAmount(saved.getAmount());
        paymentResponse.setCreatedAt(saved.getCreatedAt());

        return Response.builder()
                .status(200)
                .message("Payment Success!")
                .data(paymentResponse)
                .build();
    }

    public String generateRandomRefNumber() throws Exception {
        long timePart = System.currentTimeMillis() % 10000000000L;
        int randomPart = new Random().nextInt(100);
        long combined = timePart * 100 + randomPart;
        return String.format("%012d", combined);
    }
}
