package br.com.workshop.application.service;

import br.com.workshop.application.port.in.CustomerCrudUseCase;
import br.com.workshop.application.port.out.AddressPersistencePortOut;
import br.com.workshop.application.port.out.ContactMediumPersistencePortOut;
import br.com.workshop.application.port.out.CustomerPersistencePortOut;
import br.com.workshop.model.Customer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerCrudUseCaseImpl implements CustomerCrudUseCase {

    private CustomerPersistencePortOut customerPersistencePortOut;
    private AddressPersistencePortOut addressPersistencePortOut;
    private ContactMediumPersistencePortOut contactMediumPersistencePortOut;

    @Override
    public List<Customer> findAll() {
        return customerPersistencePortOut.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerPersistencePortOut.findById(id);
    }

    @Override
    public Customer insert(Customer customer) {
        return customerPersistencePortOut.insert(customer);
    }

    @Override
    public void update(Integer id, Customer customer) {
        Customer persistedCustomer = customerPersistencePortOut.findById(id);
        Customer updateCustomer = this.updateCustomer(persistedCustomer,customer);

        addressPersistencePortOut.deleteAllAddresses(id);
        contactMediumPersistencePortOut.deleteAllContacts(id);

        customerPersistencePortOut.update(id,updateCustomer);
    }

    @Override
    public void delete(Integer id) {
        customerPersistencePortOut.delete(id);
    }

    private Customer updateCustomer(Customer persistedCustomer, Customer customerNewData) {
        persistedCustomer.setName(customerNewData.getName());
        persistedCustomer.setBirthdate(customerNewData.getBirthdate());
        persistedCustomer.setDocumentType(customerNewData.getDocumentType());
        persistedCustomer.setDocumentNumber(customerNewData.getDocumentNumber());
        persistedCustomer.setInactive(customerNewData.getInactive());
        persistedCustomer.setAddresses(customerNewData.getAddresses());
        persistedCustomer.setContacts(customerNewData.getContacts());

        return persistedCustomer;
    }

}
