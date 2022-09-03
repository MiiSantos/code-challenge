
package br.com.challenge.app.services;

import br.com.challenge.app.models.Account;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 *
 * @author miria
 */
@Service
public interface AccountService {
     
    public Account create(Account model);
    
    public Account makeDeposit(Account model, float value);
    
    public Account makeDebit(Account model, float value);
}
