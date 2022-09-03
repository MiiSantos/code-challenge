
package br.com.challenge.app.repositories;

import br.com.challenge.app.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author miria
 */
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    
}
