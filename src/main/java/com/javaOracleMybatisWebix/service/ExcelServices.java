package com.javaOracleMybatisWebix.service;


import com.javaOracleMybatisWebix.model.KhachHang;

import jakarta.servlet.http.HttpServletResponse;


public interface ExcelServices {
	void exportExcelListKhachHang(KhachHang khachhang,
								  HttpServletResponse response) throws Exception;
}
