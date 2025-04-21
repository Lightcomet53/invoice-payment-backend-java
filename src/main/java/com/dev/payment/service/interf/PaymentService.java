package com.dev.payment.service.interf;

import com.dev.payment.dto.PaymentRequest;
import com.dev.payment.dto.Response;

public interface PaymentService {
    Response createPayment(PaymentRequest paymentRequest) throws Exception;
    String generateRandomRefNumber() throws Exception;
}
