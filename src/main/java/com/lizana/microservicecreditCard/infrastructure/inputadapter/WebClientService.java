package com.lizana.microservicecreditcard.infrastructure.inputadapter;

import com.lizana.microservicecreditcard.domain.dtos.BankAccountDto;
import com.lizana.microservicecreditcard.domain.dtos.CreditDto;
import reactor.core.publisher.Mono;

public interface WebClientService {

   <T> Mono<T> webclientpost(T dto, String endpoint, Class<T> responseType);
   Mono<CreditDto> getFromExternalService(String endPoint, String customerId);

   Mono<BankAccountDto> getFromExternalServiceBankAccount(String endPoint, String bankAccountId);
}
