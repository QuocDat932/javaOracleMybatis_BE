package com.javaOracleMybatisWebix.restController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaOracleMybatisWebix.model.KhachHang;
import com.javaOracleMybatisWebix.model.mgt.ResponseObject;
import com.javaOracleMybatisWebix.service.ExcelServices;
import com.javaOracleMybatisWebix.service.KhachHangServices;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/api/khachhang")
public class KhachHangAPI {
	@Autowired
	private KhachHangServices services;
	@Autowired
	private ExcelServices excelServices;
	
	@GetMapping("/getAllKhachHang")
	ResponseEntity<?> doGetAllKhachHang() throws Exception{
		return ResponseEntity.ok(services.getAllKhachHang());
	};
	
	@GetMapping("/getAllKhachHangROJ")
	public ResponseObject<?> doGetAllKhachHangROJ() throws Exception{
		ResponseObject result = new ResponseObject();
		result.setData(services.getAllKhachHang());
		result.setSuccess(false);
		result.setMessage("Call API Success");
		return result;
	};
	
	@GetMapping("/getKhachHangByParam")
	ResponseObject<?> doGetKhachHangByParam(KhachHang khachhang) throws Exception{
		ResponseObject reponse = new ResponseObject<>();
		try {
			reponse.setData(services.getKhachHangByParam(khachhang));
			reponse.setSuccess(true);
			reponse.setMessage("Save Successful");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail When Call API getListKhachHangByParam : ", e);
			reponse.setSuccess(false);
			reponse.setMessage("message", "Delete Fail");
		}
		return reponse;
	};
	
	@PostMapping("/postSaveUser")
	ResponseEntity<?> doPostSaveKhachHang(@RequestBody KhachHang khachhang){
		Map<String, Object> result = new HashMap<>();
		try {
			int effected = services.saveUser(khachhang);
				result.put("sucess", true);
				result.put("message", "Save Successful");
				result.put("data", effected);
		} catch (Exception e) {
			result.put("sucess", false);
			result.put("message", "Save Fail");
			log.error("False when call API ", e);
		}
		return ResponseEntity.ok(result);
	};
	
	@DeleteMapping("/deleteUserById")
	ResponseObject<?> doDeleteUserById(@RequestBody KhachHang khachhang) {
		ResponseObject reponse = new ResponseObject<>();
		try {
			int rowEffected = services.deleteKhachHang(khachhang);
			reponse.setData(rowEffected);
			reponse.setSuccess(true);
			reponse.setMessage("Save Successful");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail When Call API : ", e);
			reponse.setSuccess(false);
			reponse.setMessage("message", "Delete Fail");
		}
		return reponse;
	}
	
	@GetMapping("/getListKhachHangByParam")
	ResponseObject<?> doGetListKhachHangByParam(KhachHang khachhang){
		ResponseObject response = new ResponseObject<>();
		try {
			response.setData(services.getListKhachHangByParam(khachhang));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("message","Call API False");
			log.error("Fail when call API : ", e);
		} 
		return response;
	}
	
	@GetMapping("/exportExcelListKhachHang")
	ResponseEntity<?> exportExcelListKhachHang(KhachHang khachhang,
			 									HttpServletResponse response
			 									) throws Exception{
		response.setContentType("application/octet-stream");
		Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
        String strDate = dateFormat.format(date);
        excelServices.exportExcelListKhachHang(khachhang, response);
		String headerKey = "Content-Disposition";
        String headerValue = "replenishmentPo"+ strDate + ".xlsx";
        response.setHeader(headerKey, headerValue);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/validate-khachhang-import-excel")
	ResponseObject<?> validateDataKhachHang(@RequestBody List<KhachHang> lstKhachHang){
		ResponseObject response = new ResponseObject<>();
		try {
			response.setData(services.getValdiateKhachHangImportExcel(lstKhachHang));
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage("message","Call API False");
			log.error("Fail when call API : ", e);
		}
		return response;
	}
}
