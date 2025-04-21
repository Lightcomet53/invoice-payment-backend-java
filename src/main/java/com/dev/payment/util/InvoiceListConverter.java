package com.dev.payment.util;

import com.dev.payment.dto.InvoiceRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter
public class InvoiceListConverter implements AttributeConverter<List<InvoiceRequest>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<InvoiceRequest> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Conversion error: Unable to serialize invoices", e);
        }
    }

    @Override
    public List<InvoiceRequest> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, new TypeReference<List<InvoiceRequest>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Conversion error: Unable to deserialize JSON", e);
        }
    }
}