package com.zking.test.mapper;

import com.zking.test.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);

    List<String> listPermissionsByUserName(User user);//查询指定用户拥有的权限

    List<String> listRolesByUserName(User user);//查询指定用户拥有的角色

}