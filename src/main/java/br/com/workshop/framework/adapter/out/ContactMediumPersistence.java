package br.com.workshop.framework.adapter.out;

import br.com.workshop.application.port.out.ContactMediumPersistencePortOut;
import br.com.workshop.framework.repository.ContactMediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ContactMediumPersistence implements ContactMediumPersistencePortOut {

    @Autowired
    private ContactMediumRepository contactMediumRepository;

    @Transactional
    @Override
    public void deleteAllContacts(Integer id) {
        contactMediumRepository.deleteByCustomerId(id);
    }
}
