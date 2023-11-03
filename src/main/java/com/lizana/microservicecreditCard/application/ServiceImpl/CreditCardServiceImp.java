package com.lizana.microservicecreditcard.application.ServiceImpl;

import com.lizana.microservicecreditcard.domain.dtos.CreditCardDto;
import com.lizana.microservicecreditcard.infrastructure.inputport.CreditcardService;
import com.lizana.microservicecreditcard.infrastructure.outputadapater.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreditCardServiceImp implements CreditcardService {
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Override
    public Mono<CreditCardDto> createCreditCard(CreditCardDto creditCardDtoMono) {

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
