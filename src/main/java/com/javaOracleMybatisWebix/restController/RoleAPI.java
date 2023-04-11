package com.javaOracleMybatisWebix.restController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaOracleMybatisWebix.model.Role;
import com.javaOracleMybatisWebix.model.mgt.ResponseObject;
import com.javaOracleMybatisWebix.service.RoleServices;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/role")
@CrossOrigin(origins = {"http://localhost:8081"})
public class RoleAPI {
	@Autowired
	private RoleServices services;
	@GetMapping("/getAllRole")
	ResponseEntity<?> doGetAllRole(){
		Map<String, Object> result = new HashMap<>();
		List<Role> role = new ArrayList<>();
		try {
			role = services.getAllRole();
			result.put("data", role);
			result.put("isSuccess", true);
			result.put("message", "Success");
		} catch (Exception e) {
			log.error("Fail when call API : ", e);
			result.put("data", null);
			result.put("isSuccess", false);
			result.put("message", "Success");
		}
		return ResponseEntity.ok(result);
	};
	
	@GetMapping("/getRoleByIsuse")
	ResponseEntity<?> doGetRoleByIsuse(@RequestParam String isUse){
		Map<String, Object> result = new HashMap<>();
		List<Role> role = new ArrayList<>();
		try {
			role = services.getRoleByIsUse(isUse);
			result.put("data", role);
			result.put("isSuccess", true);
			result.put("message", "Success");
		} catch (Exception e) {
			log.error("Fail when call API : ", e);
			result.put("data", null);
			result.put("isSuccess", false);
			result.put("message", "Success");
		}
		return ResponseEntity.ok(result);
	};
	@PostMapping("/postSaveRole")
	ResponseObject<?> doPostSaveRole(@RequestBody Role role){
		ResponseObject response = new ResponseObject<>();
		try {
			System.out.println(">> "+ role.getRoleId());
			response.setData(services.saveRole(role));
		} catch (Exception e) {
			log.error("Fail when call API : ", e);
			response.setSuccess(false);
		}
		return response;
	}
}
