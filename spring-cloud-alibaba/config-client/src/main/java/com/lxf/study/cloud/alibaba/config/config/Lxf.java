package com.lxf.study.cloud.alibaba.config.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@RefreshScope
@Component
@ConfigurationProperties(prefix = "lxf")
public class Lxf {

  private String test;
}
