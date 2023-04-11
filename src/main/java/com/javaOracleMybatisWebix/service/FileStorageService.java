package com.javaOracleMybatisWebix.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	List<String> storeFile(final String bizFolder, final MultipartFile[] file) throws Exception;
}
