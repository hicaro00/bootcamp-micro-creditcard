package com.lizana.microservicecreditcard.infrastructure.outputadapater;

import com.lizana.microservicecreditcard.domain.documents.CreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCard,String> {
}
