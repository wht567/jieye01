package com.kgc.test.service.impl;

import com.kgc.test.entity.Product;
import com.kgc.test.entity.Takeout;
import com.kgc.test.mapper.ProductMapper;
import com.kgc.test.mapper.TakeoutMapper;
import com.kgc.test.service.TakeoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TakeoutServiceImpl implements TakeoutService {

    @Autowired
    private TakeoutMapper takeoutMapper;
    @Autowired
    private ProductMapper productMapper;

    public int insertSelective(Takeout record) {
        record.setOutdate(new Date());
        //根据商品id查询商品信息
        Product product = productMapper.selectByPrimaryKey(record.getProductid());
        //计算商品改变后的库存
        product.setQuantity(product.getQuantity() - record.getQuantity());
        //修改数据库
        productMapper.updateByPrimaryKeySelective(product);
        //新增出库记录
        return takeoutMapper.insertSelective(record);
    }
}
