
package br.com.challenge.app.services.impl;

import br.com.challenge.app.entities.AccountEntity;
import br.com.challenge.app.models.Account;
import br.com.challenge.app.repositories.AccountRepository;
import br.com.challenge.app.services.AccountService;

import java.util.Optional;
import java.util.Random;

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

    @Override
    public Account create(Account model) {
        if (model != null) {
            AccountEntity entity = new AccountEntity(model);
            Random random = new Random();
            entity.setNumber(random.nextInt(9999));
            entity = this.repository.save(entity);
            	
            return entity.toModel(); 
        }
        return null;
    }

    @Override
    public Account makeDeposit(Account model, Double value) {
        if (model != null) {
            Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            if (value <= 2000) {
            	Double amount = entity.getBalance();
                entity.setBalance(value + amount);
                this.repository.save(entity);
                return entity.toModel();
            } else {
                //mensagem de informação
            }
        }
        return null;
    }

    @Override
    public Account makeDebit(Account model, Double value) {
        if (model != null) {
            Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            Double amount = entity.getBalance();
            if ((amount - value) >= 0) {
                entity.setBalance(amount - value);
                this.repository.save(entity);
                return entity.toModel();
            } else {
                //mensagem informando que não há saldo
            }
        }
        return null;
    }

	@Override
	public Account makeTranfer(Account model, Double value, int accountNumber) {
		if (model != null) {
			Optional<AccountEntity> op = this.repository.findById(model.getId());
            AccountEntity entity = op.get();
            Double amount = entity.getBalance();
            if (amount - value >= 0) {
            	AccountEntity receiver = this.repository.findByAccountNumber(accountNumber);
            	if (receiver != null) {
            		Double receiverAmount = receiver.getBalance();
            		receiver.setBalance(receiverAmount + value);
            		entity.setBalance(amount - value);
            		this.repository.save(receiver);
            		entity = this.repository.save(entity);
            		
            		return entity.toModel();
            	} else {
            		//mensagem de conta não encontrada
            	}
            }
		}
		return null;
	}
}
