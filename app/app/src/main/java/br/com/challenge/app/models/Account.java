
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
}
