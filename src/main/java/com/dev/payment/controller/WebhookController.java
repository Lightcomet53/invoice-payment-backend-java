package com.dev.payment.controller;

import com.dev.payment.dto.Response;
import com.dev.payment.dto.WebhookRequest;
import com.dev.payment.service.interf.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class WebhookController {

    private final WebhookService webhookService;

    @PostMapping("/create")
    public ResponseEntity<Response> createWebhook(@RequestBody WebhookRequest webhookRequest) throws Exception {
        return ResponseEntity.ok(webhookService.createWebhook(webhookRequest));
    }
}
