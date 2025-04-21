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
    private String cardNumber;
    private String expiryDate;
    private String cvc;
    private String cardHolderName;
    private String country;
    private String zipCode;
    private List<InvoiceRequest> invoices;
    private double amount;
    private LocalDateTime createdAt;
}
