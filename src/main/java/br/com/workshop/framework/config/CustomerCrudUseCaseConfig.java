package br.com.workshop.framework.config;

import br.com.workshop.application.port.in.CustomerCrudUseCase;
import br.com.workshop.application.port.out.AddressPersistencePortOut;
import br.com.workshop.application.port.out.ContactMediumPersistencePortOut;
import br.com.workshop.application.port.out.CustomerPersistencePortOut;
import br.com.workshop.application.service.CustomerCrudUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerCrudUseCaseConfig {

    @Bean
    public CustomerCrudUseCase newUseCase(CustomerPersistencePortOut customerPersistencePortOut,
                                          AddressPersistencePortOut addressPersistencePortOut,
                                          ContactMediumPersistencePortOut contactMediumPersistencePortOut) {
        return new CustomerCrudUseCaseImpl(customerPersistencePortOut,addressPersistencePortOut,contactMediumPersistencePortOut);
    }

}
