package com.lizana.microservicecreditcard.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

    private String accountNumber;
    private String cardholderName;
    private String expirationDate;
    private double creditLimit;
    private double currentBalance;
    private List<TransactionDTO> transactionHistory;
    private double interestRate;
    private Date billingClosingDate;
    private Date paymentDueDate;
    private List<PaymentDTO> paymentHistory;
    private String accountStatus;
    private String riskLevel;
    private ContactInformationDTO contactInformation;
    private List<OfferDTO> offersAndPromotions;
}
