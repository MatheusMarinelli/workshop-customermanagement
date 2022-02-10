package br.com.workshop.framework.adapter.out;

import br.com.workshop.application.port.out.CustomerPersistencePortOut;
import br.com.workshop.framework.adapter.out.entities.CustomerEntity;
import br.com.workshop.framework.exceptions.CustomerNotFoundException;
import br.com.workshop.framework.helper.ModelMapperHelper;
import br.com.workshop.framework.repository.CustomerRepository;
import br.com.workshop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<CustomerEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapper.map(entity.get(),Customer.class);
        }
        throw new CustomerNotFoundException("Customer not found with id: " + id);
    }

    @Override
    public Customer insert(Customer customer) {
        CustomerEntity entity = mapper.map(customer, CustomerEntity.class);
        entity.setCreation(LocalDateTime.now());
        entity.setLastUpdate(LocalDateTime.now());
        entity.setInactive(LocalDate.now());
        entity.getAddresses().forEach(address -> {
            address.setCreation(LocalDateTime.now());
            address.setLastUpdate(LocalDateTime.now());
            address.setCustomer(entity);
        });
        entity.getContacts().forEach(contact -> {
            contact.setCreation(LocalDateTime.now());
            contact.setLastUpdate(LocalDateTime.now());
            contact.setCustomer(entity);
        });

        return mapper.map(repository.save(entity),Customer.class);
    }

    @Override
    public void update(Integer id, Customer customer) {
        CustomerEntity entity = mapper.map(customer, CustomerEntity.class);
        entity.setId(id);
        entity.setLastUpdate(LocalDateTime.now());
        repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        if (Objects.nonNull(findById(id))) {
            repository.deleteById(id);
        }
    }
}
