package com.project.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category_Model {
    @Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	public Category_Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category_Model(Long id, String name, List<Product_Model> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
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

	public List<Product_Model> getProducts() {
		return products;
	}

	public void setProducts(List<Product_Model> products) {
		this.products = products;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product_Model> products;

    // Getters and Setters
}
