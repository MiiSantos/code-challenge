
package br.com.challenge.app.services.impl;

import br.com.challenge.app.entities.AccountEntity;
import br.com.challenge.app.models.Account;
import br.com.challenge.app.repositories.AccountRepository;
import br.com.challenge.app.services.AccountService;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author miria
 */
public class AccountBaseService implements AccountService {
    
    @Autowired
    private AccountRepository repository;

    @Override
    public Account create(Account model) {
        if (model != null) {
            AccountEntity entity = new AccountEntity(model);
            entity = this.repository.save(entity);
            
            return entity.toModel();
        }
        return null;
    }

    @Override
    public Account makeDeposit(Account model, float value) {
        if (model != null) {
            Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            if (value <= 2000) {
                float amount = entity.getBalance();
                entity.setBalance(value + amount);
                this.repository.save(entity);
            } else {
                //mensagem de informação
            }
        }
        return null;
    }

    @Override
    public Account makeDebit(Account model, float value) {
        if (model != null) {
            Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            float amount = entity.getBalance();
            if ((amount - value) >= 0) {
                entity.setBalance(amount - value);
                this.repository.save(entity);
            } else {
                //mensagem informando que não há saldo
            }
        }
        return null;
    }
}
