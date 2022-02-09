package br.com.workshop.framework.repository;

import br.com.workshop.framework.adapter.out.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
