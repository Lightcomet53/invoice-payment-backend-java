package com.dev.payment.repository;

import com.dev.payment.entity.Webhook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookRepository extends JpaRepository<Webhook, Long> {
    boolean existsByUrl(String url);
}
