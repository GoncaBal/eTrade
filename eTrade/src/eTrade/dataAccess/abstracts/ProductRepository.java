package eTrade.dataAccess.abstracts;

import java.util.List;

import eTrade.entities.concretes.Product;

public interface ProductRepository {
	void add(Product product);
	void update(Product product);
	void delete(Product product);
	List<Product> getAll();
	Product getByProductId(int productId);
}
