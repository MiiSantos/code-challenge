
package br.com.challenge.app.repositories;

import br.com.challenge.app.entities.AccountEntity;
import br.com.challenge.app.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author miria
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    
    @Query(value = "  ")
    public Boolean checkDocument(String document);
}
