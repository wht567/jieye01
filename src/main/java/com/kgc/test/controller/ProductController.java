package com.kgc.test.controller;

import com.kgc.test.entity.Product;
import com.kgc.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("getProducts")
    @ResponseBody
    public List<Product> getProducts() {
        return productService.selectByExample();
    }

    @RequestMapping("getQuantity")
    @ResponseBody
    public Map<String, Object> getQuantity(Integer productid) {
        Integer integer = productService.selectQuantityById(productid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", integer);
        return map;
    }
}
