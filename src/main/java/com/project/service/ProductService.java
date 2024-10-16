package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.MainException;
import com.project.Model.Product_Model;
import com.project.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product_Model> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product_Model> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product_Model createProduct(Product_Model product) {
        return productRepository.save(product);
    }

    public Product_Model updateProduct(Long id, Product_Model productDetails) {
        Product_Model product = productRepository.findById(id)
                .orElseThrow(() -> new MainException("Product not found"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product_Model product = productRepository.findById(id)
                .orElseThrow(() -> new MainException("Product not found"));
        productRepository.delete(product);
    }
}

