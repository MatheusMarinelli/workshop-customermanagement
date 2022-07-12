package br.com.workshop.framework.repository;

import br.com.workshop.framework.adapter.out.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}
