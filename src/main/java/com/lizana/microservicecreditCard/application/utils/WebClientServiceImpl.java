package com.lizana.microservicecreditcard.application.utils;

import com.lizana.microservicecreditcard.application.exeptions.CustomExeption;
import com.lizana.microservicecreditcard.domain.dtos.BankAccountDto;
import com.lizana.microservicecreditcard.domain.dtos.CreditDto;
import com.lizana.microservicecreditcard.infrastructure.inputadapter.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientServiceImpl implements WebClientService {
  @Autowired
  WebClient webClient;


  @Override
  public <T> Mono<T> webclientpost(T dto, String endpoint, Class<T> responseType) {


    return webClient.post()
        .uri(endpoint)
        .body(Mono.just(dto), dto.getClass())
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError, clientResponse ->
            Mono.error(new CustomExeption("Error no se encuentra la ruta")))
        .onStatus(HttpStatus::is5xxServerError, clientResponse ->
            Mono.error(new CustomExeption("Error eroro en el objeto q se envia")))
        .bodyToMono(responseType);
  }

  @Override
  public Mono<CreditDto> getFromExternalService(String endPoint, String customerId) {
    return webClient.get()
        .uri(endPoint, customerId) // Reemplaza con el endpoint específico
        .retrieve()
        .bodyToMono(CreditDto.class)
        .onErrorResume(throwable -> Mono.just(new CreditDto()));
  }

  @Override
  public Mono<BankAccountDto> getFromExternalServiceBankAccount(String endPoint,
                                                                String bankAccountId) {
    return webClient.get()
        .uri(endPoint, bankAccountId) // Reemplaza con el endpoint específico
        .retrieve()
        .bodyToMono(BankAccountDto.class)
        .onErrorResume(throwable -> Mono.just(new BankAccountDto()));
  }
}
