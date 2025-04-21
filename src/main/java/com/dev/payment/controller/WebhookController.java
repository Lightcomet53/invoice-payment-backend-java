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
@RequestMapping("/api/webhook")
@RequiredArgsConstructor
public class WebhookController {

    private final WebhookService webhookService;

    @PostMapping("")
    public ResponseEntity<Response> createWebhook(@RequestBody WebhookRequest webhookRequest) throws Exception {
        // Check if the webhook url already exists in the database
        if (webhookService.existsByWebhookUrl(webhookRequest.getUrl())) {
            return ResponseEntity.status(409).body(Response.builder()
                    .status(409)
                    .message("The webhook URL already exists.").build());
        }

        // Process the webhook request
        return ResponseEntity.ok(webhookService.createWebhook(webhookRequest));
    }
}
