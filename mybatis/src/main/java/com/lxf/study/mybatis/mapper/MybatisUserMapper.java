package com.lxf.study.mybatis.mapper;

import com.lxf.study.mybatis.entity.MybatisUser;
import org.apache.ibatis.annotations.Param;

public interface MybatisUserMapper {
    int insertOne(@Param("user") MybatisUser user);

}
