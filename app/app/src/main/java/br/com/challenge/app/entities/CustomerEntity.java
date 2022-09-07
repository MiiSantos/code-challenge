
package br.com.challenge.app.entities;

import br.com.challenge.app.models.Customer;
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
@Table(name = "tb_customer")
public class CustomerEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer")
    private Long id;
    
    @Column(name = "customer_name")
    private String name;
    
    @Column(name = "customer_document")
    private String document;
    
    public CustomerEntity() {}

	public CustomerEntity(Customer model) {
    	this.id = model.getId();
    	this.document = model.getDocument();
    	this.name = model.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
    
    public Customer toModel() {
        Customer model = new Customer();
        model.setId(this.id);
        model.setName(this.name);
        model.setDocument(this.document);
        
        return model;
    }
}
