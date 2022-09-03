
package br.com.challenge.app.entities;

import br.com.challenge.app.models.Account;
import br.com.challenge.app.models.Customer;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author miria
 */
@Entity
@Table(name = "tb_account")
public class AccountEntity {
    
    @Id
    @Column(name="id_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="account_number")
    private int number;
    
    @Column(name="customer_balance")
    private float balance;
    
    @Column(name="deposit_value")
    private float deposit;
    
    @Column(name="account_onwer")
    @OneToOne
    private Customer onwer;
    
    public AccountEntity(Account model) {
        if (model != null) {
            this.id = model.getId();
            this.number = model.getNumber();
            this.deposit = model.getDeposit();
            this.balance = model.getBalance();
            if (model.getOnwer() != null) {
                this.onwer = model.getOnwer();
            }
        }
    }

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

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
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
