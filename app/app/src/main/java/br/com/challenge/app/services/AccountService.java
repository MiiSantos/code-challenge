
package br.com.challenge.app.services;

import br.com.challenge.app.models.Account;

/**
 *
 * @author miria
 */
public interface AccountService {
     
    public Account create(Account model);
    
    public Account makeDeposit(Account model, Double value);
    
    public Account makeDebit(Account model, Double value);
    
    public Account makeTranfer(Account model, Double value, int accountNumber);
}
