package com.lxf.study.mybatis.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MybatisUser {
    
    private Integer id;

    private String userName;

    private String password;

    private String email;

    private Integer gender;

    private Integer age;

    private LocalDateTime createTime;

}
