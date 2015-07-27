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
import java.util.Map;
import java.util.Set;
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

    @Override
    public Product getProductById(String productID) {
        return repository.getProductById(productID);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return repository.getProductsByCategory(category);
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return repository.getProductsByFilter(filterParams);
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        return repository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public Set<Product> getProductsByFilter(String category, Map<String, List<String>> filterParams, String manufacturer) {
        List<Product> productsByCategory = getProductsByCategory(category);
        List<Product> productsByManufacturer = getProductsByManufacturer(manufacturer);
        Set<Product> productsByFilter = getProductsBypriceFilter(filterParams);
        productsByFilter.retainAll(productsByCategory);
        productsByFilter.retainAll(productsByManufacturer);
        return productsByFilter;
    }

    @Override
    public Set<Product> getProductsBypriceFilter(Map<String, List<String>> filterParams) {
        return repository.getProductsBypriceFilter(filterParams);
    }

    @Override
    public void addProduct(Product product) {
        repository.addProduct(product);
    }
}
