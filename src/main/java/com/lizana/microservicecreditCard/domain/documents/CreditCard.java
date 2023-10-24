package com.lizana.microservicecreditcard.domain.documents;

import com.lizana.microservicecreditcard.domain.dtos.ContactInformationDTO;
import com.lizana.microservicecreditcard.domain.dtos.OfferDTO;
import com.lizana.microservicecreditcard.domain.dtos.PaymentDTO;
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
    private String cardId;
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




