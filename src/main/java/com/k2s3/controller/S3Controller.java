package com.k2s3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.k2s3.service.AWSS3Service;

@RestController
@RequestMapping(value = "/s3")
public class S3Controller {

	@Autowired
	private AWSS3Service service;

	@PostMapping(value = "/upload")
	public ResponseEntity<String> uploadFile(@RequestBody String anything) {
		service.uploadFile();
		final String response = "uploaded successfully.";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}