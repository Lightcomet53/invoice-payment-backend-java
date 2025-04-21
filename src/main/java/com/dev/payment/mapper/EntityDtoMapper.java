package com.dev.payment.mapper;

import com.dev.payment.dto.PaymentDto;
import com.dev.payment.entity.Payment;
import com.dev.payment.security.AESUtil;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoMapper {

    // Payment entity to DTO
    public PaymentDto mapPaymentToDtoBasic(Payment payment) throws Exception {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setEmail(payment.getEmail());
        paymentDto.setCardNumber(AESUtil.decrypt(payment.getCardNumber()));
        paymentDto.setExpiryDate(payment.getExpiryDate());
        paymentDto.setCvc(paymentDto.getCvc());
        paymentDto.setCardHolderName(payment.getCardHolderName());
        paymentDto.setCountry(payment.getCountry());
        paymentDto.setInvoices(payment.getInvoices());
        paymentDto.setAmount(payment.getAmount());
        return paymentDto;
    }
}
