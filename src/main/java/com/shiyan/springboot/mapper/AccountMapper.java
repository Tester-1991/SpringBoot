package com.shiyan.springboot.mapper;

import com.shiyan.springboot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
