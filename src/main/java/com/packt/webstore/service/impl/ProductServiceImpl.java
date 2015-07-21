/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danieljr
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public Product getProductById(String productID) {
        return repository.getProductById(productID);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return repository.getProductsByCategory(category);
    }
}
