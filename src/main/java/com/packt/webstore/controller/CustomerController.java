/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.webstore.controller;

import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danieljr
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customer;

    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customer.getAllCustomers());
        return "customers";
    }
}
