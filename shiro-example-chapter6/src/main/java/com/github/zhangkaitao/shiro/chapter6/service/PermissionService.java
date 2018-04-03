package com.github.zhangkaitao.shiro.chapter6.service;

import com.github.zhangkaitao.shiro.chapter6.entity.Permission;

/**
 * 实现基本的创建/删除权限
 * 
 * User: Zhang Kaitao
 * Date: 14-1-28
 * Version: 1.0
 */
public interface PermissionService {

	public Permission createPermission(Permission permission);

	public void deletePermission(Long permissionId);
}
