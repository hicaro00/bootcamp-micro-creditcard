package com.lizana.microservicecreditcard.application.utils;

import com.lizana.microservicecreditcard.domain.documents.CreditCard;
import com.lizana.microservicecreditcard.domain.dtos.CreditCardDto;
import org.springframework.beans.BeanUtils;

public class MaperCredit {

    private MaperCredit(){
    }

    public static CreditCardDto entityToDto(CreditCard creditCard){
      CreditCardDto creditCardDto = new CreditCardDto();
           BeanUtils.copyProperties(creditCard ,creditCardDto);
           return creditCardDto;
     }

    public static CreditCard dtoToEntity(CreditCardDto bankAccountDto){
        CreditCard creditCard = new CreditCard();
        BeanUtils.copyProperties(bankAccountDto ,creditCard);
        return creditCard;
        }
}
