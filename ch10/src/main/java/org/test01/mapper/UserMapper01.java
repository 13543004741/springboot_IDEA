package org.test01.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.entity.UserInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by langye on 2017/12/19.
 */
//baseCache对应配置文件中的baseCache名称
@CacheConfig(cacheNames = "baseCache")
public interface UserMapper01 {

    @Select("SELECT * FROM USER_INFO WHERE ID = #{id}")
    @Cacheable //加上缓存注解
    public UserInfo selectUser(@Param("id") int id);
}


