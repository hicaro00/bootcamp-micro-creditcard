package com.lizana.microservicecreditcard.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private String transactionId;
    private Date transactionDate;
    private String merchantName;
    private double amount;
    private String currency;
    private String transactionType; // Compra, retiro, etc.
    private String status; // Aprobada, rechazada, pendiente, etc.
}
