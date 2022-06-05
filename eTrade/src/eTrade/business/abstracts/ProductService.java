package eTrade.business.abstracts;

import java.util.List;

import eTrade.entities.concretes.Product;

public interface ProductService {
	
	
	
	void add(Product product);
	void update(Product product);
	void delete(Product product);
	List<Product> getAll();
	Product getByProductId(int productId);
}
