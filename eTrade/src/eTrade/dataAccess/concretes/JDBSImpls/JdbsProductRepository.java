package eTrade.dataAccess.concretes.JDBSImpls;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class JdbsProductRepository implements ProductRepository {
	List<Product> products;
	
	public JdbsProductRepository() {

products= new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
		System.out.println("JDBS ile kaydedildi: " + product.getProductName());
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return products;
	}

	

	@Override
	public Product getByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
