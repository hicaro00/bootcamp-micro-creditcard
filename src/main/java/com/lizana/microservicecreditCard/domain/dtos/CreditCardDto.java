package com.lizana.microservicecreditcard.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {
  private String cardNumber; // numero autogenerado de la tarjeta
  private String accountNumber; // nunmeor de la cuenta associada a la tarjeta
  private Signatory cardholderName; // titular de la cuenta
  private LocalDate creationDate; //
  private LocalDate expirationDate; // fecha de xpiracion de la tarjeta
  private String cardType; // credito o devito
  private BigDecimal creditLimit; //limite de credito , si fuera una tarjeta de credito si no null
  private BigDecimal currentBalance; // saldo de la tarjeta credito || devito segun la ceunta
  private List<TransactionDTO> transactionHistory; //segun donde la haya usado
  private Double interestRate; //tasa de interes si es de credito
  private LocalDate billingClosingDate; //cierre de la fecha de facturacion  || si es de credito
  private LocalDate paymentDueDate; // fechad e vencimiento del pago || si es de credito
  private List<PaymentDTO> paymentHistory;  //  historial de pagos || si es de credito
  private String accountStatus;  // estadod e la tarjeta   activa || bloqueada
  private int numberTransactions;
  private String riskLevel;  //nivle de riesgo

  private List<OfferDto> offersAndPromotions;  //ofertas o promociones
}
