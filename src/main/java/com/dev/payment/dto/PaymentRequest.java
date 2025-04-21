package com.dev.payment.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaymentRequest {
    private String email;
    private String cardNumber;
    private String expiryDate;
    private String cvc;
    private String cardHolderName;
    private String country;
    private String zipCode;
    private List<InvoiceRequest> invoices;
    private double amount;

    public boolean hasInvoices() {
        return invoices != null && !invoices.isEmpty();
    }
}
