
package br.com.challenge.app.controllers;

import br.com.challenge.app.models.Account;
import br.com.challenge.app.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity createAccount(Account model) {
        if (model != null) {
            model = this.service.create(model);
            
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

