package com.shiyan.springboot.service;

import com.shiyan.springboot.bean.City;
import com.shiyan.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityMapper cityMapper;

    public City getById(Long id) {
        return cityMapper.getById(id);
    }

    public void insert(City city) {
        cityMapper.insert(city);
    }
}
