package com.javaOracleMybatisWebix.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaOracleMybatisWebix.mapper.RoleMapper;
import com.javaOracleMybatisWebix.model.Role;
import com.javaOracleMybatisWebix.service.RoleServices;

import lombok.extern.slf4j.Slf4j;

@Service
public class RoleServicesImpl implements RoleServices {
	@Autowired
	private RoleMapper mapper;
	@Override
	public List<Role> getAllRole() throws SQLException{
		List<Role> result = new ArrayList<>();
		result = mapper.getAllRole();
		return result;
	};
	
	@Override
	public List<Role> getRoleByIsUse(String isUse) throws SQLException{
		return mapper.getRoleByIsUse(isUse);
	};
	
	@Transactional
	@Override
	public int saveRole(Role role) throws SQLException {
		if(role.getRoleId() == 0) {
			// Insert
			role.setRoleId(mapper.getNextRoleId());
			return mapper.saveNewRole(role);
		} else {
			// Update
			return mapper.updateRole(role);
		}
	}
}
