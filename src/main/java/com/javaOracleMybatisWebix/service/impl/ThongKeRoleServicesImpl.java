package com.javaOracleMybatisWebix.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaOracleMybatisWebix.mapper.ThongKeRoleMapper;
import com.javaOracleMybatisWebix.model.Role;
import com.javaOracleMybatisWebix.model.ThongKeRole;
import com.javaOracleMybatisWebix.service.ThongKeRoleServices;

@Service
public class ThongKeRoleServicesImpl implements ThongKeRoleServices{
	
	@Autowired
	private ThongKeRoleMapper mapper;
	
	@Override
	public List<ThongKeRole> listThongKeNguoiDungTheoRole() throws Exception {
		// TODO Auto-generated method stub
		return mapper.listThongKeNguoiDungTheoRole();
	};
	
	@Override
	public List<ThongKeRole> listThongKeVaiTroTheoTrangThai() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("numberA", 5);
		parameterMap.put("numberB", 4);
		mapper.AnhDev_SUMAB(parameterMap);
		System.out.println("> PL/SQL- 1F>>>"+ parameterMap.get("result"));
		
		Map<String, Object> parameterMap2 = new HashMap<String, Object>();
		parameterMap2.put("roleId", 5);
		
		//List<Role> x = mapper.checkRoleById_P(parameterMap2);
		//x.forEach(e->{
		//	System.out.println("> PL/SQL- 2P>>>"+ e.getRoleId());
		//});
		
		//mapper.checkRoleById_P(parameterMap2);
		//System.out.println("> PL/SQL- 2F>>>"+ parameterMap.get("x2"));
		
		return mapper.listThongKeVaiTroTheoTrangThai();
	}
}
