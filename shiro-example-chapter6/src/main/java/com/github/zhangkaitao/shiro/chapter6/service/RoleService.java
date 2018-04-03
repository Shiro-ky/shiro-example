package com.github.zhangkaitao.shiro.chapter6.service;

import com.github.zhangkaitao.shiro.chapter6.entity.Role;

/**
 * 相对于 PermissionService 多了关联/移除关联角色-权限功能
 * 
 * User: Zhang Kaitao 
 * Date: 14-1-28 
 * Version: 1.0
 */
public interface RoleService {

	public Role createRole(Role role);

	public void deleteRole(Long roleId);

	/**
	 * 添加角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void correlationPermissions(Long roleId, Long... permissionIds);

	/**
	 * 移除角色-权限之间关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
