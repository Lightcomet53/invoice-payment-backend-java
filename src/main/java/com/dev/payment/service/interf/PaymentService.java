package com.dev.payment.service.interf;

import com.dev.payment.dto.InvoiceItem;
import com.dev.payment.dto.PaymentRequest;
import com.dev.payment.dto.Response;

import java.util.List;

public interface PaymentService {
    Response createPayment(PaymentRequest paymentRequest) throws Exception;
    String generateRandomRefNumber() throws Exception;
}
