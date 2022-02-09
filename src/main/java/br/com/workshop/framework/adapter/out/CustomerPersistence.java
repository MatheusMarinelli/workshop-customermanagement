package br.com.workshop.framework.adapter.out;

import br.com.workshop.application.port.out.CustomerPersistencePortOut;
import br.com.workshop.framework.helper.ModelMapperHelper;
import br.com.workshop.framework.repository.CustomerRepository;
import br.com.workshop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerPersistence implements CustomerPersistencePortOut {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ModelMapperHelper mapper;

    @Override
    public List<Customer> findAll() {
        return mapper.mapToList(repository.findAll(),Customer.class);
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
