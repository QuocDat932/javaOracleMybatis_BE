package com.javaOracleMybatisWebix.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaOracleMybatisWebix.model.mgt.ResponseObject;
import com.javaOracleMybatisWebix.service.ThongKeRoleServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/thongkeRole")
@CrossOrigin(origins = {"http://localhost:8081"})
public class ThongKeRoleAPI {
	@Autowired
	private ThongKeRoleServices services;
	@GetMapping("/thongKeNguoiDungTheoRole")
	public ResponseObject<?> doGetThongKeLuongUserTheoRole(){
		ResponseObject result = new ResponseObject();
		try {
			result.setData(services.listThongKeNguoiDungTheoRole());
			
		} catch (Exception e) {
			log.error("Fail When Call API : ", e);
			result.setSuccess(false);
		}
		return result;
	};
	
	@GetMapping("/thongVaiTroTheoTrangThai") 
	public ResponseObject<?> doGetThongVaiTroTheoTrangThai(){
		ResponseObject result = new ResponseObject();
		try {
			result.setData(services.listThongKeVaiTroTheoTrangThai());
			
		} catch (Exception e) {
			log.error("Fail When Call API : ", e);
			result.setSuccess(false);
		}
		return result;
	}
	
}
