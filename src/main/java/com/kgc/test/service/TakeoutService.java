package com.kgc.test.service;

import com.kgc.test.entity.Takeout;

public interface TakeoutService {

    /**
     * 新增出库记录
     * @param record 记录数据封装的实体类
     * @return 改变的数据行数
     */
    int insertSelective(Takeout record);
}
