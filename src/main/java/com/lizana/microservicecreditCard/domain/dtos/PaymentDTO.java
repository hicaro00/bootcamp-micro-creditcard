package com.lizana.microservicecreditcard.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private String paymentId;
    private Date paymentDate;
    private double amount;
    private String currency;
    private String paymentType; // Pago mínimo, pago total, etc.
    private String status; // Realizado, pendiente, atrasado, etc.
}
