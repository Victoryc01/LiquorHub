package com.blaze.liquorhub.repository;

import com.blaze.liquorhub.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<Product, Long> {

  //  Product delete(Long product_id);
   // void deleteById(Long id);
}
