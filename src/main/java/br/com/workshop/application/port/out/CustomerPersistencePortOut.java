package br.com.workshop.application.port.out;

import br.com.workshop.model.Customer;

import java.util.List;

public interface CustomerPersistencePortOut {

    List<Customer> findAll();
    Customer findById(Integer id);
    Customer insert(Customer customer);
    void update(Integer id, Customer customer);
    void delete(Integer id);

}
