package com.sk.user.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * @author shirken
 * @describe
 * @date 2024/2/5 5:16 PM
 */
@Configuration
public class MyBatisMapperConfig {
    @Bean
    public MapperScannerConfigurer userMyBatisMapperScannerConfig() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("userSqlSessionFactory");
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("userSqlSessionTemplate");
        mapperScannerConfigurer.setBasePackage("com.sk.user.provider.db.user");
        buildProperties(mapperScannerConfigurer);
        return mapperScannerConfigurer;
    }
    @Bean
    public MapperScannerConfigurer accountMyBatisMapperScannerConfig() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("accountSqlSessionFactory");
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("accountSqlSessionTemplate");
        mapperScannerConfigurer.setBasePackage("com.sk.user.provider.db.account");
        buildProperties(mapperScannerConfigurer);
        return mapperScannerConfigurer;
    }
    private void buildProperties(MapperScannerConfigurer mapperScannerConfigurer) {
        Properties properties = new Properties();
        properties.setProperty("mappers", "com.sk.user.provider.db.base.MyMapper");
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        properties.setProperty("style", "normal");
        mapperScannerConfigurer.setProperties(properties);
    }
}
