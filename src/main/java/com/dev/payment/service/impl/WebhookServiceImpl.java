package com.dev.payment.service.impl;

import com.dev.payment.dto.PaymentDto;
import com.dev.payment.dto.Response;
import com.dev.payment.dto.WebhookRequest;
import com.dev.payment.entity.Payment;
import com.dev.payment.entity.Webhook;
import com.dev.payment.mapper.EntityDtoMapper;
import com.dev.payment.repository.WebhookRepository;
import com.dev.payment.service.interf.WebhookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebhookServiceImpl implements WebhookService {

    private final WebhookRepository webhookRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final EntityDtoMapper entityDtoMapper;

    @Override
    public Response createWebhook(WebhookRequest webhookRequest) throws Exception {
//        if (webhookRepository.existsByUrl(webhookRequest.getUrl())) {
//            return Response.builder()
//                    .status(409)
//                    .message("The webhook URL already exists.")
//                    .build();
//        }
        Webhook webhook = new Webhook();
        webhook.setUrl(webhookRequest.getUrl());
        webhookRepository.save(webhook);
        return Response.builder()
                .status(200)
                .message("Webhook created successfully")
                .build();
    }

    @Override
    @Async
    public void sendToAllWebhook(Payment savedPayment) throws Exception {
        PaymentDto paymentDto = entityDtoMapper.mapPaymentToDtoBasic(savedPayment);
        List<Webhook> webhooks = webhookRepository.findAll();
        for (Webhook webhook : webhooks) {
            sendWithRetry(webhook.getUrl(), paymentDto, 3);
        }
    }

    @Override
    public void sendWithRetry(String url, PaymentDto paymentDto, int retries) {
        for (int i = 0; i < retries; i++) {
            try {
                restTemplate.postForEntity(url, paymentDto, String.class);
                break;
            } catch (Exception e) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    @Override
    public boolean existsByWebhookUrl(String url) throws Exception {
        return webhookRepository.existsByUrl(url);
    }

}
