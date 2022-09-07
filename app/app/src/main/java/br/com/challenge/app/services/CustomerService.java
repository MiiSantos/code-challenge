package br.com.challenge.app.services;

import br.com.challenge.app.models.Customer;

/**
 *
 * @author miria
 */
public interface CustomerService {
    
	public Customer create(Customer model);
	
	public Boolean findByDocument(Customer model);
}
