package org.wayne.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @TODO: 代码形式配置mybatis
 * @author: lwq
 */
@Configuration
@MapperScan(basePackages = {"org.wayne.mapper"})
public class MybatisConfig {

}
