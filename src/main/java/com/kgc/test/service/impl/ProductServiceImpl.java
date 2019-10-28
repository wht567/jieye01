package com.kgc.test.service.impl;

import com.kgc.test.entity.Product;
import com.kgc.test.entity.ProductExample;
import com.kgc.test.mapper.ProductMapper;
import com.kgc.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Integer selectQuantityById(Integer id) {
        Product product = productMapper.selectQuantityById(id);
        Integer quantity = product.getQuantity();
        return quantity;
    }

    public List<Product> selectByExample() {
        //创建空的参数封装类
        ProductExample example = new ProductExample();
        //查询全部
        return productMapper.selectByExample(example);
    }
}
