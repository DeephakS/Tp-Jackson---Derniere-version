package com.example.demo;

import java.io.ByteArrayOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;


public class DemoApplication {


	public static String javaToJson(Object obj) {
		ObjectMapper objMap = new ObjectMapper();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			objMap.writeValue(buffer, obj);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		String reponse = buffer.toString();
		return reponse;
	}
	
	public static <T> T fromJsonToJava(String json, Class<T> clss) {
		ObjectMapper objMap = new ObjectMapper();
		try {
			T res = (T) objMap.readValue(json, clss);
			return (T) res;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}

