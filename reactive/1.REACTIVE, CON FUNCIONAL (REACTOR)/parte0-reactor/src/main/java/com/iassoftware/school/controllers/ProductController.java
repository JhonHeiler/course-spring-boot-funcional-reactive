package com.iassoftware.school.controllers;

import com.iassoftware.school.dao.ProductDao;
import com.iassoftware.school.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

@Controller

public class ProductController {
    @Autowired
    private ProductDao dao;

    @GetMapping({"/listar","/"})
    public String listar(Model model){
        Flux<Product> products = dao.findAll();
        model.addAttribute("products",products);
        model.addAttribute("titulo","listado de productos");
        return "listar";
    }
}
