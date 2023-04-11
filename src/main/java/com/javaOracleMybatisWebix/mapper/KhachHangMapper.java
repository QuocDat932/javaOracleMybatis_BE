package com.javaOracleMybatisWebix.mapper;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.javaOracleMybatisWebix.model.KhachHang;

@Mapper
public interface KhachHangMapper {
	List<KhachHang> getAllKhachHang();
	int insertKhachHang(KhachHang khachHang);
	int updateKhachHang(KhachHang khachHang);
	int deleteKhachHang(KhachHang khachhang);
	KhachHang getKhachHangByParam(KhachHang khachhang);
	List<KhachHang> getListKhachHangByParam(KhachHang khachhang);
}