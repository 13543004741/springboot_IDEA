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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by langye on 2017/12/20.
 * 数据源1
 */
@Configuration //注入到spring容器中
@MapperScan(basePackages = {"org.test01"},sqlSessionFactoryRef = "test01SqlSessionFactory")
public class Datasource01 {

    /**
     * 配置test01数据库
     * @return
     */
    @Bean(name = "test01DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test01")
    @Primary //自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
    public DataSource testDataSource(){
        return  DataSourceBuilder.create().build();
    }

    /**
     * test01 sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "test01SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test01DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //如需加载分页（则放行）
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver.getResource("classpath:mybatis/mapper/test01/*.xml"));
        return bean.getObject();
    }

    /**
     * test01事务管理
     * @param dataSource
     * @return
     */
    @Bean(name = "test01TransactionManager")

    public DataSourceTransactionManager testTransactionManager(@Qualifier("test01DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * sqlSession 模板
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "test01TransactionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test01SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);

    }

}
