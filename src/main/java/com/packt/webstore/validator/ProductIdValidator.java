/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author danieljr
 */
public class ProductIdValidator implements
        ConstraintValidator<ProductId, String> {

    @Autowired
    private ProductService productService;

    @Override
    public void initialize(ProductId constraintAnnotation) {
        //		intentionally	left	blank;	this	is	the	place	toinitialize	the  constraint annotation	for any sensibledefault	  values.  
        {

        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product;
        try {
            product = productService.getProductById(value);
        } catch (ProductNotFoundException e) {
            return true;
        }
        if (product != null) {
            return false;
        }
        return true;
    }
}
