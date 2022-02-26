package br.com.workshop.framework.repository;

import br.com.workshop.framework.adapter.out.entities.ContactMediumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactMediumRepository extends JpaRepository<ContactMediumEntity, Integer> {

    @Modifying
    @Query(value = "DELETE FROM ContactMediumEntity c WHERE c.customer.id=:id ")
    void deleteByCustomerId(@Param("id") Integer id);

}
