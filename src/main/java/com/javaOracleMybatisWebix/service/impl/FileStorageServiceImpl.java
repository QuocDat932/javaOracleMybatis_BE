package com.javaOracleMybatisWebix.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaOracleMybatisWebix.service.FileStorageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileStorageServiceImpl implements FileStorageService{
	@Override
	public List<String> storeFile(final String bizFolder, final MultipartFile[] files) throws Exception{
		//String rootPath = "src\\main\\resources\\static\\img\\avata\\";
		String rootPath = "E:\\Webix\\Projects\\jet-start-master\\img\\"; //Webix
		Path rootFolder = Paths.get(rootPath);
		List<String> result = new ArrayList<>(files.length);
		try {
			// source default save img avata
			
			for(MultipartFile file: files) {
				
				// check name of file
				String fileName = file.getOriginalFilename();
				//
				int min = 1;
				int max = 999;
				String folderRadom = fileName.replaceAll(" ", "")+(Math.random()*(max - min + 1) + min);
				String onlyFolder = folderRadom.replace(".","")+"\\";
				if(fileName == null || fileName.length() == 0) {
					// set new name for file when if is true
					fileName = System.currentTimeMillis() + ".png";
				};
				String personalFolder_String = Paths.get(rootPath+onlyFolder).toAbsolutePath().toString();
				Path peronalPath = Paths.get(personalFolder_String);
				// Check path personal is existed ?
				if(!peronalPath.toFile().getCanonicalPath().startsWith(personalFolder_String) || !peronalPath.toFile().mkdir()) {
					// create folder when not exit?
					peronalPath.toFile().mkdir();
				}
				//Path onlyPathSave = saveFolder.resolve(onlyFolder).normalize();
				Path filePath = peronalPath.resolve(fileName).normalize();
				// copy from system and create new file
				Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				//filePath.toString().substring(filePath.toString().indexOf("img")+4, filePath.toString().length())
				result.add(filePath.toString().substring(filePath.toString().indexOf(rootPath), filePath.toString().length()));
			}
		} catch (Exception e) {
			if(rootFolder != null) {
				Files.deleteIfExists(rootFolder);
				log.error("failt to store file ", e);
				return Collections.emptyList();
			}
		}
		return result;
	};
}
