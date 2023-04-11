package com.javaOracleMybatisWebix.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaOracleMybatisWebix.service.FileStorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/api/file")
public class FileAPI {
	@Autowired
	private FileStorageService storeFile;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("files") MultipartFile[] files,
											              @RequestParam("bizFolder") String bizFolder,
											              @RequestParam(value = "avataUserId", required = false) String avataUserId
															){
		Map<String, Object> response = new HashMap<>();
		try {
			response.put("paths", storeFile.storeFile(bizFolder, files));
		} catch (Exception e) {
			log.error("uploadFile: ", e);
            response.put("msg","Upload failed");
		};
		return ResponseEntity.ok(response);
	}
}
