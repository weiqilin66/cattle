package org.wayne.thief.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: lwq
 */
@Configuration
@MapperScan(basePackages = {"org.wayne.thief.mapper"})
public class MybatisConfig {
}
