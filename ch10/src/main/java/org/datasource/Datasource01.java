package org.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.DBConfig.DBConfig01;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by langye on 2017/12/20.
 * 数据源1
 */
@Configuration //注入到spring容器中
@MapperScan(basePackages = {"org.test01"},sqlSessionFactoryRef = "test01SqlSessionFactory")
public class Datasource01 {

    /**
     * 数据源
     * (jta-automatic 将数据源集中管理)
     * @param dbConfig01
     * @return
     * @throws SQLException
     */
    @Primary
    @Bean(name = "test01DataSource")
    public DataSource test01DataSource(DBConfig01 dbConfig01) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dbConfig01.getUrl());
        mysqlXADataSource.setPassword(dbConfig01.getPassword());
        mysqlXADataSource.setUser(dbConfig01.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
        dataSourceBean.setXaDataSource(mysqlXADataSource);
        dataSourceBean.setUniqueResourceName("test01DataSource");
        dataSourceBean.setMinPoolSize(dbConfig01.getMinPoolSize());
        dataSourceBean.setMaxPoolSize(dbConfig01.getMaxPoolSize());
        dataSourceBean.setMaxLifetime(dbConfig01.getMaxLifetime());
        dataSourceBean.setBorrowConnectionTimeout(dbConfig01.getBorrowConnectionTimeout());
        dataSourceBean.setLoginTimeout(dbConfig01.getLoginTimeout());
        dataSourceBean.setMaintenanceInterval(dbConfig01.getMaintenanceInterval());
        dataSourceBean.setMaxIdleTime(dbConfig01.getMaxIdleTime());
        dataSourceBean.setTestQuery(dbConfig01.getTestQuery());
        return dataSourceBean;
    }

    /**
     * test01 sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "test01SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test01DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //如需加载分页（则放行）
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver.getResource("classpath:mybatis/mapper/test01/*.xml"));
        return bean.getObject();
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
