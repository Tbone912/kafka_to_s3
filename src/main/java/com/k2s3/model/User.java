package com.k2s3.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	
	@JsonProperty("userName")
	String userName;
	
	@JsonProperty("id")
	int id;

}
