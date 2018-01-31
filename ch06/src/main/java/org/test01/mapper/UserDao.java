package org.test01.mapper;

import org.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by langye on 2017/12/19.
 */
public interface UserDao extends JpaRepository<UserInfo,Serializable> {

}
