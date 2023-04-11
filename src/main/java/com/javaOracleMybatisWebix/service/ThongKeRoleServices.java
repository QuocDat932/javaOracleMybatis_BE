package com.javaOracleMybatisWebix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaOracleMybatisWebix.model.ThongKeRole;

public interface ThongKeRoleServices {
	List<ThongKeRole> listThongKeNguoiDungTheoRole() throws Exception;
	List<ThongKeRole> listThongKeVaiTroTheoTrangThai() throws Exception;
}
