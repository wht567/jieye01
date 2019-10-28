package com.kgc.test.service;

import com.kgc.test.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询库存数量
     * @param id 商品id
     * @return 查询到的数量封装进实体类
     */
    Integer selectQuantityById(Integer id);

    /**
     * 查询全部商品信息
     * @return 查询到的结果用实体类集合封装返回
     */
    List<Product> selectByExample();
}
