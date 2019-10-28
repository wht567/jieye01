package com.kgc.test.mapper;

import com.kgc.test.entity.Takeout;
import com.kgc.test.entity.TakeoutExample;
import java.util.List;

public interface TakeoutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Takeout record);

    int insertSelective(Takeout record);

    List<Takeout> selectByExample(TakeoutExample example);

    Takeout selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Takeout record);

    int updateByPrimaryKey(Takeout record);
}