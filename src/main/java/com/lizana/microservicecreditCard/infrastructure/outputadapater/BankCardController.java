package com.lizana.microservicecreditcard.infrastructure.outputadapater;

import com.lizana.microservicecreditcard.domain.dtos.CreditCardDto;
import com.lizana.microservicecreditcard.infrastructure.inputport.CreditcardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/request-card")
@Log4j2
public class BankCardController {

  @Autowired
  CreditcardService creditcardService;

  @PostMapping("/newcard")
  @ResponseBody
  @ExceptionHandler
  public Mono<CreditCardDto> requestCard(@RequestBody CreditCardDto creditCardDto) {
    try {
      Mono<CreditCardDto> created = creditcardService.createCreditCard(creditCardDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(created).getBody();
    } catch (Exception ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Algo salió mal al procesar la solicitud");
    }
  }

}
