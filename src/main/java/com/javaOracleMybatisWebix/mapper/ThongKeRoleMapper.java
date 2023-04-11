package com.javaOracleMybatisWebix.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.javaOracleMybatisWebix.model.Role;
import com.javaOracleMybatisWebix.model.ThongKeRole;

@Mapper
public interface ThongKeRoleMapper {
	List<ThongKeRole> listThongKeNguoiDungTheoRole() throws SQLException;
	List<ThongKeRole> listThongKeVaiTroTheoTrangThai() throws SQLException;
	public void AnhDev_SUMAB(Map<String, Object> parameterMap) throws SQLException;
	public void checkRoleById_P(Map<String, Object> parameterMap) throws SQLException;

}
