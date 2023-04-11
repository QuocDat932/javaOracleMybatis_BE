package com.javaOracleMybatisWebix.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.javaOracleMybatisWebix.model.Role;

@Mapper
public interface RoleMapper {
	List<Role> getAllRole();
	List<Role> getRoleByIsUse(@Param("isUse") String isUse);
	
	@Transactional
	int getNextRoleId();
	
	@Transactional
	int saveNewRole(Role role);
	
	int updateRole(Role role);
}
