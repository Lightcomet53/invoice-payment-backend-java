package com.dev.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String email;
    private String cardNumber;
    private String expiryDate;
    private String cvc;
    private String cardHolderName;
    private String country;
    private String zipCode;
    private List<InvoiceItem> invoices;
    private double amount;

    public boolean hasInvoices() {
        return invoices != null && !invoices.isEmpty();
    }
}
