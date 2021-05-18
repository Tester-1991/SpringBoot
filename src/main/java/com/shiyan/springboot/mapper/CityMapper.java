package com.shiyan.springboot.mapper;

import com.shiyan.springboot.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    public void insert(City city);
}

