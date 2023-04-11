package com.javaOracleMybatisWebix.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaOracleMybatisWebix.mapper.KhachHangMapper;
import com.javaOracleMybatisWebix.model.KhachHang;
import com.javaOracleMybatisWebix.model.mgt.MasterCode;
import com.javaOracleMybatisWebix.service.KhachHangServices;

@Service
public class KhachHangServicesImpl implements KhachHangServices {
	@Autowired
	private KhachHangMapper mapper;
	
	@Override
	public List<KhachHang> getAllKhachHang() throws SQLException{
		// TODO Auto-generated method stub
		return mapper.getAllKhachHang();
	};
	
	@Override
	public int saveUser(KhachHang user) throws SQLException{
		user.slipImgSrc();
		if(user.getMaKh() == null) {
			System.out.println("Insert");
			return mapper.insertKhachHang(user);
		} else {
			System.out.println("Update");
			return mapper.updateKhachHang(user);
		}
		
	};
	
	@Override
	public int deleteKhachHang(KhachHang khachhang) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.deleteKhachHang(khachhang);
	};
	
	@Override
	public KhachHang getKhachHangByParam(KhachHang khachhang) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.getKhachHangByParam(khachhang);
	};
	
	@Override
	public List<KhachHang> getListKhachHangByParam(KhachHang khachhang) throws SQLException{
		return mapper.getListKhachHangByParam(khachhang);
	};
	
	@Override
	public List<KhachHang> getValdiateKhachHangImportExcel(List<KhachHang> lstKhachHang) throws SQLException{
		List<KhachHang> lstResultValidate = new ArrayList<>();
		lstKhachHang.forEach(e ->{
			String invalid = "";
			// Lay Thong Tin Khach Hang Trong He Thong
			// May Theo Ma
			KhachHang systemKh = mapper.getKhachHangByParam(e);
			if(Objects.isNull(systemKh)) {
				//Insert
				invalid = MasterCode.invalidMgt.NEW_RECORD.getCode();
				e.setMode(invalid);
				lstResultValidate.add(e);
				
			}
			else{
				// check 
				// check name
				if(!e.getTenKh().equals(systemKh.getTenKh())) {
					invalid += MasterCode.invalidMgt.IVL_NAME.getCode();
				};
				if(e.getRoleId() != systemKh.getRoleId()) {
					invalid += "-"+MasterCode.invalidMgt.INV_ROLE.getCode();
				};
				systemKh.setMode(invalid);
				lstResultValidate.add(systemKh);
			};
		});
		return lstResultValidate;
	}
	
}
