package eTrade.dataAccess.concretes.hibernateImpls;

import java.util.ArrayList;
import java.util.List;

import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class HibernateProductRepository implements ProductRepository {
	List<Product> products;

	public HibernateProductRepository() {
		products = new ArrayList<Product>();
	}

	@Override
	public void add(Product product) {
		products.add(product);
		System.out.println("Hibernate ile kaydedildi: " + product.getProductName());

	}

	@Override
	public void update(Product product) {
		Product productToUpdate = getByProductId(product.getProductId());
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		System.out.println("Hibernate ile güncellendi: " + product.getProductName());
	}

	@Override
	public void delete(Product product) {
		products.remove(getByProductId(product.getProductId()));
		System.out.println("Hibenate ile silindi: " + product.getProductName());

	}

	@Override
	public List<Product> getAll() {

		return products;

	}

	@Override
	public Product getByProductId(int productId) {
		Product productToFind = null;
		for (Product item : products) {
			if (item.getProductId() == productId) {
				productToFind = item;
			}
		}
		return productToFind;
	}

}
