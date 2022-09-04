
package br.com.challenge.app.services;

import java.math.BigDecimal;

import br.com.challenge.app.models.Account;

/**
 *
 * @author miria
 */
public interface AccountService {
     
    public Account create(Account model);
    
    public Account makeDeposit(Account model, BigDecimal value);
    
    public Account makeDebit(Account model, BigDecimal value);
    
    public Account makeTranfer(Account model, BigDecimal value, int accountNumber);
}
