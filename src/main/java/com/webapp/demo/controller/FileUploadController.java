package com.webapp.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	public String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	
	@PostMapping(path = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String UploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		
		StringBuilder fileBuilder = new StringBuilder();
		
		Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY,file.getOriginalFilename());
		fileBuilder.append(file.getOriginalFilename());
		Files.write(fileNameAndPath,file.getBytes());
		
		return "upload success file";
	}

}
