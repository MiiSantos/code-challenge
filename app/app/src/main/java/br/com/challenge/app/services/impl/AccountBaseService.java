
package br.com.challenge.app.services.impl;

import br.com.challenge.app.entities.AccountEntity;
import br.com.challenge.app.entities.CustomerEntity;
import br.com.challenge.app.models.Account;
import br.com.challenge.app.repositories.AccountRepository;
import br.com.challenge.app.repositories.CustomerRepository;
import br.com.challenge.app.services.AccountService;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miria
 */
@Service
public class AccountBaseService implements AccountService {
    
    @Autowired
    private AccountRepository repository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Account create(Account model) {
        if (model != null) {
            AccountEntity entity = new AccountEntity(model);
            CustomerEntity customer = this.customerRepository.findByDocument(entity.getOnwer().getDocument());
            if (customer != null) {
            	//mensagem de esse cliente ja possui conta
            } else {
            	entity = this.repository.save(entity);
            }
            return entity.toModel();
        }
        return null;
    }

    @Override
    public Account makeDeposit(Account model, BigDecimal value) {
        if (model != null) {
            Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            if (value.compareTo(value) <= 2000) {
            	BigDecimal amount = entity.getBalance();
                entity.setBalance(value.add(amount));
                this.repository.save(entity);
            } else {
                //mensagem de informação
            }
        }
        return null;
    }

    @Override
    public Account makeDebit(Account model, BigDecimal value) {
        if (model != null) {
            Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            BigDecimal amount = entity.getBalance();
            if (amount.subtract(value).signum() >= 0) {
                entity.setBalance(amount.subtract(value));
                this.repository.save(entity);
            } else {
                //mensagem informando que não há saldo
            }
        }
        return null;
    }

	@Override
	public Account makeTranfer(Account model, BigDecimal value, int accountNumber) {
		if (model != null) {
			Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            BigDecimal amount = entity.getBalance();
            if (amount.subtract(value).signum() >= 0) {
            	AccountEntity receiver = this.repository.findByAccountNumber(accountNumber);
            	if (receiver != null) {
            		BigDecimal receiverAmount = receiver.getBalance();
            		receiver.setBalance(receiverAmount.add(value));
            		entity.setBalance(amount.subtract(value));
            		
            		return entity.toModel();
            	} else {
            		//mensagem de conta não encontrada
            	}
            }
		}
		return null;
	}
}
