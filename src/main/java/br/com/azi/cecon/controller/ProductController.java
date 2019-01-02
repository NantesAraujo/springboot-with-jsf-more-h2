package br.com.azi.cecon.controller;

import br.com.azi.cecon.entity.Product;
import br.com.azi.cecon.interfaces.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "productController")
@ELBeanName(value = "productController")
@Join(path = "/product", to = "/product-form.jsf")
public class ProductController {

	@Autowired
	public ProductRepository productRepository;

	private Product product = new Product();

	public String save(){
		productRepository.save(this.product);
		product = new Product();

		return "/product-list.xhtml?faces-redirect=true";
	}

	public Product getProduct(){
		return product;
	}

}
