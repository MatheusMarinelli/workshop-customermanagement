package br.com.workshop.application.service;

import br.com.workshop.application.port.in.CustomerCrudUseCase;
import br.com.workshop.application.port.out.CustomerPersistencePortOut;
import br.com.workshop.framework.adapter.out.entities.AddressEntity;
import br.com.workshop.framework.adapter.out.entities.ContactMediumEntity;
import br.com.workshop.framework.adapter.out.entities.CustomerEntity;
import br.com.workshop.framework.helper.ModelMapperHelper;
import br.com.workshop.model.Customer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerCrudUseCaseImpl implements CustomerCrudUseCase {

    private CustomerPersistencePortOut customerPersistencePortOut;
    private ModelMapperHelper mapper;

    @Override
    public List<Customer> findAll() {
        return customerPersistencePortOut.findAll();
    }

    @Override
    public Customer findById(String id) {
        return mapper.map(customerPersistencePortOut.findById(id),Customer.class);
    }

    @Override
    public Customer insert(Customer customer) {
        return mapper.map(customerPersistencePortOut.insert(customer),Customer.class);
    }

    @Override
    public void update(String id, Customer customer) {
        CustomerEntity persistedCustomer = customerPersistencePortOut.findById(id);
        CustomerEntity updateCustomer = this.updateCustomer(persistedCustomer,customer);

        customerPersistencePortOut.update(id,updateCustomer);
    }

    @Override
    public void delete(String id) {
        customerPersistencePortOut.delete(id);
    }

    private CustomerEntity updateCustomer(CustomerEntity persistedCustomer, Customer customerNewData) {
        persistedCustomer.setName(customerNewData.getName());
        persistedCustomer.setBirthdate(customerNewData.getBirthdate());
        persistedCustomer.setDocumentType(customerNewData.getDocumentType());
        persistedCustomer.setDocumentNumber(customerNewData.getDocumentNumber());
        persistedCustomer.setInactive(customerNewData.getInactive());
        persistedCustomer.setAddresses(mapper.mapToList(customerNewData.getAddresses(), AddressEntity.class));
        persistedCustomer.setContacts(mapper.mapToList(customerNewData.getContacts(), ContactMediumEntity.class));

        return persistedCustomer;
    }

}
