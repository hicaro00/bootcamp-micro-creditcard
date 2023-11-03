package com.lizana.microservicecreditcard.domain.documents;

import com.lizana.microservicecreditcard.domain.dtos.ContactInformationDto;
import com.lizana.microservicecreditcard.domain.dtos.OfferDto;
import com.lizana.microservicecreditcard.domain.dtos.PaymentDTO;
import com.lizana.microservicecreditcard.domain.dtos.Signatory;
import com.lizana.microservicecreditcard.domain.dtos.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("bankCards")
public class CreditCard {
    @Id
    private String cardNumber; // numero autogenerado de la tarjeta
    private String accountNumber; // nunmeor de la cuenta associada a la tarjeta
    private Signatory cardholderName; // titular de la cuenta
    private String expirationDate; // fecha de xpiracion de la tarjeta
    private String cardType; // credito o devito
    private double creditLimit; //limite de credito , si fuera una tarjeta de credito si no null
    private double currentBalance; // saldo de la tarjeta credito || devito segun la ceunta
    private List<TransactionDTO> transactionHistory; //segun donde la haya usado
    private double interestRate; //tasa de interes si es de credito
    private Date billingClosingDate; //cierre de la fecha de facturacion  || si es de credito
    private Date paymentDueDate; // fechad e vencimiento del pago || si es de credito
    private List<PaymentDTO> paymentHistory;  //  historial de pagos || si es de credito
    private String accountStatus;  // estadod e la tarjeta   activa || bloqueada
    private String riskLevel;  //nivle de riesgo

    private List<OfferDto> offersAndPromotions;  //ofertas o promociones
}




