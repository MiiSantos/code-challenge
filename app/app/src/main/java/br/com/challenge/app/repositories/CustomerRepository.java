
package br.com.challenge.app.repositories;

import br.com.challenge.app.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author miria
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
	@Query(value = " select * from tb_customer c where c.customer_document = :document ", nativeQuery = true)
	public CustomerEntity findByDocument(@Param("document") String document);
}
