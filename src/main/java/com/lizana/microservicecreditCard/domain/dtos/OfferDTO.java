package com.lizana.microservicecreditcard.domain.dtos;

import lombok.AllArgsConstructor;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {
  private String offerId;
  private String offerTitle;
  private String offerDescription;
  private Date offerExpirationDate;
}
