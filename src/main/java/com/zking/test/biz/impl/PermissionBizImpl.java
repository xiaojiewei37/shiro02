package com.zking.test.biz.impl;

import com.zking.test.biz.IPermissionBiz;
import com.zking.test.mapper.PermissionMapper;
import com.zking.test.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionBizImpl implements IPermissionBiz {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int add(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int del(Permission permission) {
        return permissionMapper.deleteByPrimaryKey(permission.getPermissionId());
    }
}
