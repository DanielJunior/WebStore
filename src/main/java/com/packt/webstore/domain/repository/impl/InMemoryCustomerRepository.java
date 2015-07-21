/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danieljr
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer amazon = new Customer("C123", "Amazon", "Street View");
        Customer magazine = new Customer("C234", "Magazine Luiza", "Silicius Ville");
        listOfCustomers.add(amazon);
        listOfCustomers.add(magazine);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }

}
