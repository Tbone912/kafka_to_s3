package com.k2s3.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AWSS3Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(AWSS3Service.class);

	@Autowired
	private AmazonS3 amazonS3;
	@Value("${aws.s3.bucket}")
	private String bucketName;

	// @Override
	// @Async annotation ensures that the method is executed in a different
	// background thread
	// but not consume the main thread.
	@Async
	public void uploadFile() {
		LOGGER.info("File upload in progress.");
		try {
			File file = new File("toS3.txt");
			uploadFileToS3Bucket(bucketName, file);
			LOGGER.info("File upload is completed.");
			file.delete();
		} catch (final AmazonServiceException ex) {
			LOGGER.info("File upload is failed.");
			LOGGER.error("Error= {} while uploading file.", ex.getMessage());
		}
	}


	private void uploadFileToS3Bucket(final String bucketName, final File file) {
		final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
		LOGGER.info("Uploading file with name= " + uniqueFileName);
		final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
		amazonS3.putObject(putObjectRequest);
	}
}