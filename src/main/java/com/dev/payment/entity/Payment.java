package com.dev.payment.entity;

import com.dev.payment.dto.InvoiceRequest;
import com.dev.payment.util.InvoiceListConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "Card number is mandatory")
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_date")
    private String expiryDate;

    @NotBlank(message = "Card number is mandatory")
    private String cvc;

    @Column(name = "card_holder_name")
    @NotBlank(message = "Card holder name is mandatory")
    private String cardHolderName;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @NotBlank(message = "ZIP Code is mandatory")
    @Column(name = "zip_code")
    private String zipCode;

// if invoice table exists
//    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<Invoice> invoices;

    @Convert(converter = InvoiceListConverter.class)
    @Column(columnDefinition = "LONGTEXT")
    private List<InvoiceRequest> invoices;

    private Double amount;

    @NotBlank(message = "Ref number is mandatory")
    @Column(name = "ref_number")
    private String refNumber;

    @Column(name = "created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();
}
