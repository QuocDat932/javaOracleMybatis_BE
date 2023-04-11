package com.javaOracleMybatisWebix.service;

import java.sql.SQLException;
import java.util.List;

import com.javaOracleMybatisWebix.model.Role;

public interface RoleServices {
	List<Role> getAllRole() throws SQLException;
	List<Role> getRoleByIsUse(String isUse) throws SQLException;
	
	int saveRole(Role role) throws SQLException;
}
