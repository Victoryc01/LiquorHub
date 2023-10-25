package com.blaze.liquorhub.service;

import com.blaze.liquorhub.model.Product;
import com.blaze.liquorhub.repository.ProductRep;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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



    public Product addProduct(String name, String description, double price,  int category_id, int quantity) {
        Product product = new Product();

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory_id(category_id);
        product.setQuantity(quantity);

        return productRep.save(product);
    }

    public void deleteProductById(Long product_id) {
        productRep.deleteById(product_id);
    }

}
