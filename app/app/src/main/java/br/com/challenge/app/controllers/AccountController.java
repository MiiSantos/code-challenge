
package br.com.challenge.app.controllers;

import br.com.challenge.app.models.Account;
import br.com.challenge.app.services.AccountService;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author miria
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private AccountService service;
    
    @PostMapping
    public ResponseEntity<Account> createAccount(Account model) {
        if (model != null) {
            model = this.service.create(model);
            
            return new ResponseEntity<Account>(model, HttpStatus.CREATED);
        }
        return new ResponseEntity<Account>(model, HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/deposit/{id}")
    public ResponseEntity<Account> deposit(@PathVariable Long id, BigDecimal value) {
    	Account model = new Account();
    	model.setId(id);
    	model = this.service.makeDeposit(model, value);
    	if (model != null) {
    		return new ResponseEntity<Account>(model, HttpStatus.OK);
    	}
    	return new ResponseEntity<Account>(model, HttpStatus.NO_CONTENT);	
    }
    
    @PutMapping("/debit/{id}")
    public ResponseEntity<Account> debit(@PathVariable Long id, BigDecimal value) {
    	Account model = new Account();
    	model.setId(id);
    	model = this.service.makeDebit(model, value);
    	if (model != null) {
    		return new ResponseEntity<Account>(model, HttpStatus.OK);
    	}
    	return new ResponseEntity<Account>(model, HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/transfer/{id}")
    public ResponseEntity<Account> transfer(@PathVariable Long id, BigDecimal value, int receiverNumber) {
    	Account model = new Account();
    	model.setId(id);
    	model = this.service.makeTranfer(model, value, receiverNumber);
    	if (model != null) {
    		return new ResponseEntity<Account>(model, HttpStatus.OK);
    	}
    	return new ResponseEntity<Account>(model, HttpStatus.NO_CONTENT);
    }
}

