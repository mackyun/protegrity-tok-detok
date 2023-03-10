package com.protegrity.protegritytokdetok.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.protegrity.protegritytokdetok.exceptions.ProtegrityException;
import com.protegrity.protegritytokdetok.model.ProtegrityFields;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@EnableRetry
public class TokenizeService {
	@Autowired
	ProtegrityService protegrityService;

	@Autowired
	ProtegrityValidationResponse validateResponse;

	@Retryable(maxAttempts = 2, value = { ProtegrityException.class })
	public ProtegrityFields getTokenizeData(ProtegrityFields data) {

		
		JSONObject jsonList = protegrityService.generateToken(getJsonList(data));
		return getData(data, jsonList);
	}
	
	private JSONObject getJsonList(ProtegrityFields data) {
		JSONObject objList = new JSONObject();
		/*
		 * getFirstNamePolicy(data, objList); getLastNamePolicy(data, objList);
		 */
		return objList;
	}

	/*
	 * @SuppressWarnings("unchecked") private void getFirstNamePolicy(Book book,
	 * List<JSONObject> objList) { if (!StringUtils.isEmpty(book.getBookName())) {
	 * JSONObject obj = new JSONObject(); obj.put("policyName", "firstName");
	 * obj.put("bookName", book.getBookName()); objList.add(obj); } }
	 * 
	 * @SuppressWarnings("unchecked") private void getLastNamePolicy(Book book,
	 * List<JSONObject> objList) { if (!StringUtils.isEmpty(book.getAuthorName())) {
	 * JSONObject obj = new JSONObject(); obj.put("policyName", "lastName");
	 * obj.put("authorName", book.getAuthorName()); objList.add(obj); } }
	 */

	private ProtegrityFields getData(ProtegrityFields data, JSONObject jsonList) {
		ProtegrityFields updatedData = new ProtegrityFields();
	try {
//			for (int i=0;i<jsonList.size();i++) {
//				if (!StringUtils.isEmpty((String) obj.get("SSN"))) {
//					updatedData.setSSN((String) obj.get("SSN"));
//				}
//				if (!StringUtils.isEmpty((String) obj.get("authorName"))) {
//					updatedData.setFirstName((String) obj.get("firstName"));
//				}
//			}

			validateResponse.validateData(data, updatedData);
			//
			data.setFirstName(updatedData.getFirstName());
			data.setSSN(updatedData.getSSN());
			//
		} catch (ProtegrityException ex) {
			log.error(ex);
			throw ex;
		}
		return data;
	}
}
