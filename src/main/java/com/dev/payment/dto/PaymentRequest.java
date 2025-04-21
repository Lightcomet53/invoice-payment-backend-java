package com.dev.payment.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaymentRequest {
    private String email;
    private String cvc;
    private String expiryDate;
    private String cardHolderName;
    private String zipCode;
    private String cardNumber;
    private List<InvoiceRequest> invoices;
    private double amount;

    public boolean hasInvoices() {
        return invoices != null && !invoices.isEmpty();
    }
}
