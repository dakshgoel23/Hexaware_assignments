package com.hibernate.service;

import java.util.List;
import java.util.Scanner;

import com.hibernate.exception.InvalidIdException;
import com.hibernate.model.Vendor;
import com.hibernate.model.Product;
//import com.hibernate.model.Address;
import com.hibernate.model.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ProductService {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	public ProductService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager=entityManager;
		this.entityTransaction=entityTransaction;
	}
	public Product takeInput(Scanner sc)
	{
		Product product=new Product();
		System.out.println("Enter Product Title");
		sc.nextLine();
		product.setTitle(sc.nextLine());
		System.out.println("Enter  description");
		product.setDescription(sc.nextLine());
		System.out.println("Enter Price");
		product.setPrice(sc.nextDouble());
		
		System.out.println("--------Vendor Info---------");
		Vendor vendor=new Vendor();
		
		System.out.println("Enter vendor name");
		sc.nextLine();
		vendor.setName(sc.nextLine());
		System.out.println("Enter City");
		vendor.setCity(sc.nextLine());
		 int vendorId =(int) (Math.random()*10000000);
		 vendor.setId(vendorId);
		 product.setVendor(vendor);
		 
		 
		 System.out.println("----------Category Info-------");
		 Category category=new Category();
		 System.out.println("Enter name");
		 category.setName(sc.nextLine());
		 System.out.println("Enter Sequence");
		 category.setSequence(sc.nextInt());
		 int categoryId =(int) (Math.random()*10000000);
		 category.setId(categoryId);
		 product.setCategory(category);

		return product;
	}
	public void saveVendor(Vendor vendor) {
		entityTransaction.begin();
		entityManager.persist(vendor);
		entityTransaction.commit();

	}
	
	public void saveCategory(Category category) {
		entityTransaction.begin();
		entityManager.persist(category);
		entityTransaction.commit();

	}
	public void insert(Product product)
	{
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
	}
	
	public List<Product> getAllUsingHQL() {
		entityTransaction.begin();
		String hql="from Product";
		TypedQuery <Product> query = entityManager.createQuery(hql, Product.class);
		
		entityTransaction.commit();
		return query.getResultList();
	}
	public List<Product> getAllUsingCriteriaQuery() {
		entityTransaction.begin();
		CriteriaBuilder criteriaBuilder =  entityManager.getCriteriaBuilder();
		CriteriaQuery <Product> criteriaQuery =  criteriaBuilder.createQuery(Product.class);
		Root<Product> rootProduct =  criteriaQuery.from(Product.class);
		criteriaQuery.select(rootProduct);
		TypedQuery <Product> query = entityManager.createQuery(criteriaQuery);
		entityTransaction.commit();
		return query.getResultList();
	}
	public Product getById(Scanner sc) throws InvalidIdException{
		entityTransaction.begin();
		System.out.println("Enter product id");
		int id=sc.nextInt();
		Product product = entityManager.find(Product.class, id);
		if(product==null)
		{
			throw new InvalidIdException("Product ID Invaild");
		}
		entityTransaction.commit();
		return product;
		
	}
	public void delete(Product product) {
		entityTransaction.begin();
		entityManager.remove(product);
		entityTransaction.commit();
		
	}
	public List<Product> getAll() {
		entityTransaction.begin();
		String jpql="select p from Product p";
		TypedQuery<Product> typedQuery=entityManager.createQuery(jpql, Product.class);
		List<Product> list=typedQuery.getResultList();
		entityTransaction.commit();
		return list;
	}
	
	

}
