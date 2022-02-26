package br.com.workshop.framework.repository;

import br.com.workshop.framework.adapter.out.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

    @Modifying
    @Query(value = "DELETE FROM AddressEntity a WHERE a.customer.id=:id ")
    void deleteByCustomerId(@Param("id") Integer id);

}
