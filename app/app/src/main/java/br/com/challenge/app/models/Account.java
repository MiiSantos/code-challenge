
package br.com.challenge.app.models;

import java.math.BigDecimal;

/**
 *
 * @author miria
 */
public class Account {
    private Long id;
    private int number;
    private BigDecimal balance;
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

    public Customer getOnwer() {
        return onwer;
    }

    public void setOnwer(Customer onwer) {
        this.onwer = onwer;
    }
}
