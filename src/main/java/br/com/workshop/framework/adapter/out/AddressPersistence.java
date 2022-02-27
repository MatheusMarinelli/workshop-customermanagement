package br.com.workshop.framework.adapter.out;

import br.com.workshop.application.port.out.AddressPersistencePortOut;
import br.com.workshop.framework.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AddressPersistence implements AddressPersistencePortOut {

    @Autowired
    private AddressRepository repository;

    @Transactional
    @Override
    public void deleteAllAddresses(Integer id) {
        repository.deleteByCustomerId(id);
    }

}
