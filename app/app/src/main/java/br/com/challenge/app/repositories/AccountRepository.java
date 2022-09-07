
package br.com.challenge.app.repositories;

import br.com.challenge.app.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author miria
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    
	@Query(value = " select * from tb_account a where a.account_number = :accountNumber ", nativeQuery = true)
	public AccountEntity findByAccountNumber(@Param("accountNumber") int accountNumber);
}
