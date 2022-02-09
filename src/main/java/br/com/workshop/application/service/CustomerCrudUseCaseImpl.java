package br.com.workshop.application.service;

import br.com.workshop.application.port.in.CustomerCrudUseCase;
import br.com.workshop.application.port.out.CustomerPersistencePortOut;
import br.com.workshop.model.Customer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerCrudUseCaseImpl implements CustomerCrudUseCase {

    private CustomerPersistencePortOut portOut;

    @Override
    public List<Customer> findAll() {
        return portOut.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public Customer insert(Customer customer) {
        return null;
    }

    @Override
    public void update(Integer id, Customer customer) {

    }

    @Override
    public void delete(Integer id) {

    }
}
