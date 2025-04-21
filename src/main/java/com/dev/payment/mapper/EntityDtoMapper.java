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
        paymentDto.setCvc(paymentDto.getCvc());
        paymentDto.setCardNumber(AESUtil.decrypt(payment.getCardNumber()));
        paymentDto.setCardHolderName(payment.getCardHolderName());
        paymentDto.setEmail(payment.getEmail());
        paymentDto.setExpiryDate(payment.getExpiryDate());
        paymentDto.setInvoices(payment.getInvoices());
        return paymentDto;
    }
}
