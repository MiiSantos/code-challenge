
package br.com.challenge.app.entities;

import br.com.challenge.app.models.Account;
import br.com.challenge.app.models.Customer;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author miria
 */
@Entity
public class AccountEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int number;
    
    private BigDecimal balance;
    
    private BigDecimal deposit;
    
    private Customer onwer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Customer getOnwer() {
        return onwer;
    }

    public void setOnwer(Customer onwer) {
        this.onwer = onwer;
    }
    
    public Account toModel() {
        Account model = new Account();
        model.setId(this.id);
        model.setBalance(this.balance);
        model.setDeposit(this.deposit);
        model.setNumber(this.number);
        if (this.onwer != null) {
            model.setOnwer(this.onwer);
        }
        
        return model;
    }
}
