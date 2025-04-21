package com.dev.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private String email;
    private String cvc;
    private String expiryDate;
    private String cardHolderName;
    private String zipCode;
    private String cardNumber;
    private List<InvoiceRequest> invoices;
    private double amount;
    private LocalDateTime createdAt;
}
