package eTrade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eTrade.business.abstracts.ProductService;
import eTrade.business.concretes.ProductManager;
import eTrade.dataAccess.abstracts.ProductRepository;
import eTrade.dataAccess.concretes.JDBSImpls.JdbsProductRepository;
import eTrade.dataAccess.concretes.hibernateImpls.HibernateProductRepository;
import eTrade.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		// TODO 
		//ayný isim ürün olamaz.
		//ayný kategoride en fazla 5 ürün olacak.
		//fiyat 0 dan küçük olamaz.
		
//		List<ProductRepository> productRepositories=new ArrayList<ProductRepository>();
//		productRepositories.add(new HibernateProductRepository());
//		productRepositories.add(new JdbsProductRepository());
	//	ProductService productService=new ProductManager(productRepositories);
		
		ProductService productService=new ProductManager(new HibernateProductRepository());
		
		Product product1= new Product(1,1,"Elma",10);
		Product product2= new Product(2,1,"Erik",10);
		Product product3= new Product(3,1,"Çilek",10);
		Product product4= new Product(4,1,"Ayva",10);
		Product product5= new Product(3,1,"Elma",10);
		Product product6= new Product(6,2,"Viþne",20);

		
		productService.add(product1);
		productService.add(product2);
		productService.add(product3);
		productService.add(product4);
		productService.add(product5);
		productService.add(product6);
		
	//	productService.delete(product5);
		productService.update(product5);
		for (Product item : productService.getAll()) {
			System.out.println(item.getProductName());
		}
		//productService.getAll();
	
	}

}
