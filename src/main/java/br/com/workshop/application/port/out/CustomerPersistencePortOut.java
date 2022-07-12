package br.com.workshop.application.port.out;

import br.com.workshop.framework.adapter.out.entities.CustomerEntity;
import br.com.workshop.model.Customer;

import java.util.List;

public interface CustomerPersistencePortOut {

    List<Customer> findAll();
    CustomerEntity findById(String id);
    CustomerEntity insert(Customer customer);
    void update(String id, CustomerEntity customer);
    void delete(String id);

}
