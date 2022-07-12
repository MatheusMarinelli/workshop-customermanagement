package br.com.workshop.framework.config;

import br.com.workshop.application.port.in.CustomerCrudUseCase;
import br.com.workshop.application.port.out.CustomerPersistencePortOut;
import br.com.workshop.application.service.CustomerCrudUseCaseImpl;
import br.com.workshop.framework.helper.ModelMapperHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerCrudUseCaseConfig {

    @Bean
    public CustomerCrudUseCase newUseCase(CustomerPersistencePortOut customerPersistencePortOut, ModelMapperHelper mapper){
        return new CustomerCrudUseCaseImpl(customerPersistencePortOut,mapper);
    }

}
