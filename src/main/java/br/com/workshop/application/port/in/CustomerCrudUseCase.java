package br.com.workshop.application.port.in;

import br.com.workshop.model.Customer;

import java.util.List;

public interface CustomerCrudUseCase {

    List<Customer> findAll();
    Customer findById(String id);
    Customer insert(Customer customer);
    void update(String id, Customer customer);
    void delete(String id);

}
