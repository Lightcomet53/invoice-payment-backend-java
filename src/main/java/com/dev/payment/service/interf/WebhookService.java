package com.dev.payment.service.interf;

import com.dev.payment.dto.PaymentDto;
import com.dev.payment.dto.Response;
import com.dev.payment.dto.WebhookRequest;
import com.dev.payment.entity.Payment;

public interface WebhookService {
    Response createWebhook(WebhookRequest webhookRequest) throws Exception;
    void sendToAllWebhook(Payment payment) throws Exception;
    void sendWithRetry(String url, PaymentDto paymentDto, int retries) throws Exception;
}
