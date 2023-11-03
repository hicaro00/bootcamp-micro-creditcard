package com.lizana.microservicecreditcard.domain.dtos;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalAmountDto {


        private String withdrawalId;
        private BigDecimal amount;
        private Date dateWithdrawal;
}
