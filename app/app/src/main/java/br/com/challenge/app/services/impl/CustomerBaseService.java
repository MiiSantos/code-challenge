
package br.com.challenge.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.challenge.app.entities.CustomerEntity;
import br.com.challenge.app.models.Customer;
import br.com.challenge.app.repositories.CustomerRepository;
import br.com.challenge.app.services.CustomerService;

/**
 *
 * @author miria
 */
@Service
public class CustomerBaseService implements CustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
	@Override
	public Customer create(Customer model) {
		CustomerEntity customer = new CustomerEntity(model);
		if (customer != null) {
			this.customerRepository.save(customer);
			return customer.toModel();
		}
		return null;
	}

	@Override
	public Customer findByDocument(Customer model) {
		if (model != null) {
			CustomerEntity customer = this.customerRepository.findByDocument(model.getDocument());
			if (customer != null) {
				return customer.toModel();			
			}
		}
		return null;
	}	
}
