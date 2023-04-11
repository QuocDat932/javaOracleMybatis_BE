package com.javaOracleMybatisWebix.service;

import java.sql.SQLException;
import java.util.List;

import com.javaOracleMybatisWebix.model.KhachHang;

public interface KhachHangServices {
	List<KhachHang> getAllKhachHang() throws SQLException;
	int saveUser(KhachHang khachhang) throws SQLException;
	int deleteKhachHang(KhachHang khachhang) throws SQLException;
	KhachHang getKhachHangByParam(KhachHang khachhang) throws SQLException;
	List<KhachHang> getListKhachHangByParam(KhachHang khachhang) throws SQLException;
	List<KhachHang> getValdiateKhachHangImportExcel(List<KhachHang> lstKhachHang) throws SQLException;
}
