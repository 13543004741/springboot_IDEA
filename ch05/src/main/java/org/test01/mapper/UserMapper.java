package org.test01.mapper;

import org.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by langye on 2017/12/19.
 */
public interface UserMapper {

    @Select("SELECT * FROM USER_INFO WHERE USER_NAME = #{userName}")
    UserInfo findName(@Param("userName") String userName);
}
