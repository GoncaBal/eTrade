package eTrade.business.concretes;

import java.util.List;

import eTrade.business.abstracts.ProductService;
import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.entities.concretes.Product;

public class ProductManager implements ProductService {

	// List<ProductRepository> productRepositories;
	private ProductRepository productRepository;

	public ProductManager(ProductRepository productRepository) { // List<ProductRepository>
		this.productRepository = productRepository;

	}

	@Override
	public void add(Product product) {
//		for (ProductRepository item : productRepository) {
//			item.add(product);
//		}
		if (!checkIfProductNameExist(product.getProductName())) {
			if (product.getUnitPrice() > 0) {
				if (countOfCategoryId(product) < 5) {
					productRepository.add(product);
				}else {
					System.out.println("Bu kategoride 5'ten fazla ürün eklenemez.");
				}
			}else {
				System.out.println("Para birimi geçersiz!");
			}
		} else {
			System.out.println("Mevcut isim: "+product.getProductName());
		}
	}

	@Override
	public void update(Product product) {
		productRepository.update(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.getAll();
	}

	@Override
	public Product getByProductId(int productId) {
		return productRepository.getByProductId(productId);
	}

	private boolean checkIfProductNameExist(String productName) {
		boolean exists = false;
		for (Product item : productRepository.getAll()) {
			if (item.getProductName() == productName) {
				exists = true;
			}
		}
		return exists;
	}

	private int countOfCategoryId(Product product) {
		int count = 0;
		for (Product item : productRepository.getAll()) {
			if (item.getCategoryId() == product.getCategoryId()) {
				count++;
			}
		}
		return count;
	}

}
