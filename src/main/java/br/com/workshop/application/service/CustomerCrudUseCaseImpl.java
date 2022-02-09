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
        return portOut.findById(id);
    }

    @Override
    public Customer insert(Customer customer) {
        return portOut.insert(customer);
    }

    @Override
    public void update(Integer id, Customer customer) {
        Customer persistedCustomer = portOut.findById(id);
        Customer updateCustomer = this.updateCustomer(persistedCustomer,customer);
        portOut.update(id,updateCustomer);
    }

    @Override
    public void delete(Integer id) {
        portOut.delete(id);
    }

    private Customer updateCustomer(Customer persistedCustomer, Customer customerNewData) {
        persistedCustomer.setName(customerNewData.getName());
        persistedCustomer.setBirthdate(customerNewData.getBirthdate());
        persistedCustomer.setDocumentType(customerNewData.getDocumentType());
        persistedCustomer.setDocumentNumber(customerNewData.getDocumentNumber());
        persistedCustomer.setAddresses(customerNewData.getAddresses());
        persistedCustomer.setContacts(customerNewData.getContacts());

        return persistedCustomer;
    }

}
