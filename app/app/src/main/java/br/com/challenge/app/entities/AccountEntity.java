
package br.com.challenge.app.entities;

import br.com.challenge.app.models.Account;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private Double balance;
    
    @OneToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity onwer;
    
    public AccountEntity() {}
    
    public AccountEntity(Account model) {
        if (model != null) {
            this.id = model.getId();
            this.number = model.getNumber();
            this.balance = model.getBalance();
            if (model.getOnwer() != null) {
                this.onwer = new CustomerEntity(model.getOnwer());
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
 
    public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public CustomerEntity getOnwer() {
		return onwer;
	}

	public void setOnwer(CustomerEntity onwer) {
		this.onwer = onwer;
	}

	public Account toModel() {
        Account model = new Account();
        model.setId(this.id);
        model.setBalance(this.balance);
        model.setNumber(this.number);
        if (this.onwer != null) {
            model.setOnwer(this.onwer.toModel());
        }
        
        return model;
    }
}
