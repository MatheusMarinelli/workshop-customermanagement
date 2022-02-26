package br.com.workshop.framework.repository;

import br.com.workshop.framework.adapter.out.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query("SELECT c.creation FROM CustomerEntity c WHERE c.id=:id")
    LocalDateTime findCreationDateById(@Param("id")Integer id);

}
