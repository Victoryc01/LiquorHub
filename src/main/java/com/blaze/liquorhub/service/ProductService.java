package com.blaze.liquorhub.service;

import com.blaze.liquorhub.model.Product;
import com.blaze.liquorhub.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRep productRep;

    @Autowired
    public ProductService(ProductRep productRep) {
        this.productRep = productRep;
    }

    public List<Product> getAllProduct(){
        return productRep.findAll();
    }
}
