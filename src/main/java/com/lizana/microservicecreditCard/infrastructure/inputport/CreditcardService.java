package com.lizana.microservicecreditcard.infrastructure.inputport;

import com.lizana.microservicecreditcard.domain.dtos.CreditCardDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditcardService {

    Mono<CreditCardDto> createCreditCard( CreditCardDto creditCardDtoMono); //solicitar una tarjeta

    Mono<CreditCardDto> updateCrediCard(Mono<CreditCardDto> creditCardDtoMono, String id);

    Flux<CreditCardDto> getCredirCard();

    Mono<CreditCardDto> getCreditCardById(String idCreditCard);

    Mono<Void> deleteCreditCardById(String idCreditCard);

}
