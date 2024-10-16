package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Product_Model;

@Repository
public interface ProductRepository extends JpaRepository<Product_Model, Long> {}
