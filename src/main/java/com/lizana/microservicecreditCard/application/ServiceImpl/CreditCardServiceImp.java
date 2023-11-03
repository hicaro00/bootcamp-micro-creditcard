package com.lizana.microservicecreditcard.application.serviceimpl;

import com.lizana.microservicecreditcard.application.utils.MaperCredit;
import com.lizana.microservicecreditcard.domain.dtos.BankAccountDto;
import com.lizana.microservicecreditcard.domain.dtos.CreditCardDto;
import com.lizana.microservicecreditcard.domain.dtos.CreditDto;
import com.lizana.microservicecreditcard.infrastructure.inputadapter.WebClientService;
import com.lizana.microservicecreditcard.infrastructure.inputport.CreditcardService;
import com.lizana.microservicecreditcard.infrastructure.outputport.CreditCardRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardserviceImp implements CreditcardService {
  @Autowired
  CreditCardRepository creditCardRepository;
  @Autowired
  WebClientService webClientService;

  private static final String URI_SERVICE_CREDIT = "http://localhost:9090/v1/credit/{id}";
  private static final String URI_SERVICE_BANKACCOUNT = "http://localhost:8090/account/info/{id}";

  @Override
  public Mono<CreditCardDto> createCreditCard(CreditCardDto creditCarDto) {
    String accountId = creditCarDto.getAccountNumber(); // extraer el numeero de cuentae
    if ("CREDIT".equals(creditCarDto.getCardType())) {
      Mono<CreditDto> credit =
          webClientService.getFromExternalService(URI_SERVICE_CREDIT, accountId);
      return credit.flatMap(creditDto -> {
        CreditCardDto newcreditCard = new CreditCardDto();
        newcreditCard.setCardNumber(UUID.randomUUID().toString());
        newcreditCard.setAccountNumber(accountId);
        newcreditCard.setCardholderName(creditCarDto.getCardholderName());
        newcreditCard.setCreationDate(LocalDate.now());
        newcreditCard.setExpirationDate((LocalDate.now()).plus(4, ChronoUnit.YEARS));
        newcreditCard.setCardType(creditCarDto.getCardType());
        newcreditCard.setCreditLimit(creditDto.getTotalAmount());
        newcreditCard.setCurrentBalance(creditDto.getTotalAmount());
        newcreditCard.setInterestRate(creditDto.getInterestRate());
        newcreditCard.setBillingClosingDate((LocalDate.now()).withDayOfMonth(10));
        newcreditCard.setPaymentDueDate((LocalDate.now()).withDayOfMonth(10));
        newcreditCard.setAccountStatus(creditDto.getAccountStatus());
        newcreditCard.setRiskLevel("BAJO");

        return creditCardRepository.insert(MaperCredit.dtoToEntity(newcreditCard))
            .map(MaperCredit::entityToDto);


      });
    } else if ("DEBIT".equals(creditCarDto.getCardType())) {
      Mono<BankAccountDto> bankAccount =
          webClientService.getFromExternalServiceBankAccount(URI_SERVICE_BANKACCOUNT, accountId);
      return bankAccount.flatMap(bankAccountDto -> {
        CreditCardDto newCreditcard = new CreditCardDto();
        newCreditcard.setCardNumber(UUID.randomUUID().toString());
        newCreditcard.setAccountNumber(accountId);
        newCreditcard.setCardholderName(creditCarDto.getCardholderName());
        newCreditcard.setCreationDate(LocalDate.now());
        newCreditcard.setExpirationDate((LocalDate.now()).plus(4, ChronoUnit.YEARS));
        newCreditcard.setCardType(creditCarDto.getCardType());
        newCreditcard.setCurrentBalance(bankAccountDto.getAvailableBalance());
        newCreditcard.setNumberTransactions(bankAccountDto.getNumberTransactions());
        newCreditcard.setAccountStatus(bankAccountDto.getAccountStatus());
        newCreditcard.setRiskLevel("BAJO");
        return creditCardRepository.insert(MaperCredit.dtoToEntity(newCreditcard))
            .map(MaperCredit::entityToDto);
      });

    }

    //  extraer en tipo de cuenta normal o de credito
    // solicitus get a l servicio de cuetnas bancarias o creditos segun sea el caso
    // setear el resto de campos y segun loo requerido
    //finalmente guardar la tarjeta en la base de datos
    return null;
  }

  @Override
  public Mono<CreditCardDto> updateCrediCard(Mono<CreditCardDto> creditCardDtoMono, String id) {
    return null;
  }

  @Override
  public Flux<CreditCardDto> getCredirCard() {
    return null;
  }

  @Override
  public Mono<CreditCardDto> getCreditCardById(String idCreditCard) {
    return null;
  }

  @Override
  public Mono<Void> deleteCreditCardById(String idCreditCard) {
    return null;
  }
}
