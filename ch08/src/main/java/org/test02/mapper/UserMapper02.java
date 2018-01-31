package org.test02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by langye on 2017/12/19.
 */
public interface UserMapper02 {
    @Insert("INSERT INTO USER_INFO VALUES(NULL,#{name},#{password})")
    public int addUser(@Param("name") String name, @Param("password") String password);
}
