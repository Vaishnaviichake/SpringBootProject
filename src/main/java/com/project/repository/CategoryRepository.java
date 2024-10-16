package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Category_Model;

@Repository
public interface CategoryRepository extends JpaRepository<Category_Model, Long> {}

