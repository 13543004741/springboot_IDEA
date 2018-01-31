package org.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by langye on 2017/12/20.
 * 数据源1
 */
@Configuration
@MapperScan(basePackages = {"org.test02"},sqlSessionFactoryRef = "test02SqlSessionFactory")
public class Datasource02 {

    /**
     * 配置test02数据库
     * @return
     */
    @Bean(name = "test02DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test02")
    public DataSource testDataSource(){
        return  DataSourceBuilder.create().build();
    }

    /**
     * test02 sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "test02SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test02DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //如需加载分页（则放行）
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver.getResource("classpath:mybatis/mapper/test02/*.xml"));
        return bean.getObject();
    }

    /**
     * test02事务管理
     * @param dataSource
     * @return
     */
    @Bean(name = "test02TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test02DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * sqlSession 模板
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "test02TransactionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test02SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);

    }

}
