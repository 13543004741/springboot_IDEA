package org.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.DBConfig.DBConfig02;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by langye on 2027/12/20.
 * 数据源1
 */
@Configuration //注入到spring容器中
@MapperScan(basePackages = {"org.test02"},sqlSessionFactoryRef = "test02SqlSessionFactory")
public class Datasource02 {

    /**
     * 数据源
     * @param dbConfig02
     * @return
     * @throws SQLException
     */
    @Bean(name = "test02DataSource")
    public DataSource test02DataSource(DBConfig02 dbConfig02) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dbConfig02.getUrl());
        mysqlXADataSource.setPassword(dbConfig02.getPassword());
        mysqlXADataSource.setUser(dbConfig02.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
        dataSourceBean.setXaDataSource(mysqlXADataSource);
        dataSourceBean.setUniqueResourceName("test02DataSource");
        dataSourceBean.setMinPoolSize(dbConfig02.getMinPoolSize());
        dataSourceBean.setMaxPoolSize(dbConfig02.getMaxPoolSize());
        dataSourceBean.setMaxLifetime(dbConfig02.getMaxLifetime());
        dataSourceBean.setBorrowConnectionTimeout(dbConfig02.getBorrowConnectionTimeout());
        dataSourceBean.setLoginTimeout(dbConfig02.getLoginTimeout());
        dataSourceBean.setMaintenanceInterval(dbConfig02.getMaintenanceInterval());
        dataSourceBean.setMaxIdleTime(dbConfig02.getMaxIdleTime());
        dataSourceBean.setTestQuery(dbConfig02.getTestQuery());
        return dataSourceBean;
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
     * sqlSession 模板
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "test02TransactionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test02SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);

    }

}
