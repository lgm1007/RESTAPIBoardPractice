package com.mycomp.exboard.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import com.zaxxer.hikari.HikariDataSource;

/*
 * @ComponentScan : 서비스 객체 스캔
 * @MapperScan : 대상 패키지에 있는 Mapper를 스캔
 * @ConfigurationProperties : application.properties 파일에서 spring.datasource.hikari로
 * 시작하는 설정 정보를 사용함으로 prefix를 spring.datasource.hikari로 설정
 */

@ComponentScan(basePackages="com.mycomp.exboard.service")
@MapperScan(basePackages="com.mycomp.exboard.service", sqlSessionFactoryRef = "sqlSessionFactory")
@Configuration
public class DataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.type(HikariDataSource.class).build();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
