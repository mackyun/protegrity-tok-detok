package com.protegrity.protegritytokdetok.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.protegrity.protegritytokdetok.exceptions.ProtegrityException;
import com.protegrity.protegritytokdetok.model.ProtegrityFields;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProtegrityValidationResponse {
	public void validateData(ProtegrityFields data, ProtegrityFields updatedData) {
		log.info("Inside ProtegrityValidationResponse validateData");

		try {
		validateSSN(data, updatedData);
		validateFirstName(data, updatedData);
		validateLastName(data, updatedData);
		validateDOB(data, updatedData);
		validateEmail(data,updatedData);
		validateOtherID(data,updatedData);
		}
		catch(ProtegrityException ex) {
			log.error(ex);
			throw ex;
		}
	}

	private void validateOtherID(ProtegrityFields data, ProtegrityFields updatedData) {
		if (!StringUtils.isEmpty(data.getOtherID())) {
			if (StringUtils.isEmpty(updatedData.getOtherID())) {
				throw getException("SSN is empty");
			} else if (data.getOtherID().equals(updatedData.getOtherID())) {
				throw getException("Protegrity Api sent same data for SSN");
			}
		}
		
	}

	private void validateEmail(ProtegrityFields data, ProtegrityFields updatedData) {
		if (!StringUtils.isEmpty(data.getEmail())) {
			if (StringUtils.isEmpty(updatedData.getEmail())) {
				throw getException("SSN is empty");
			} else if (data.getEmail().equals(updatedData.getEmail())) {
				throw getException("Protegrity Api sent same data for SSN");
			}
		}
		
	}

	private void validateDOB(ProtegrityFields data, ProtegrityFields updatedData) {
		
		
	}

	private void validateLastName(ProtegrityFields data, ProtegrityFields updatedData) {
		if (!StringUtils.isEmpty(data.getLastName())) {
			if (StringUtils.isEmpty(updatedData.getLastName())) {
				throw getException("LastName is empty");
			} else if (data.getLastName().equals(updatedData.getLastName())) {
				throw getException("Protegrity Api sent same data for LastName");
			}
		}
		
	}

	private void validateSSN(ProtegrityFields data, ProtegrityFields updatedData) {
		if (!StringUtils.isEmpty(data.getSSN())) {
			if (StringUtils.isEmpty(updatedData.getSSN())) {
				throw getException("SSN is empty");
			} else if (data.getSSN().equals(updatedData.getSSN())) {
				throw getException("Protegrity Api sent same data for SSN");
			}
		}
	}

	private void validateFirstName(ProtegrityFields data, ProtegrityFields updatedData) {
		if (!StringUtils.isEmpty(data.getFirstName())) {
			if (StringUtils.isEmpty(updatedData.getFirstName())) {
				throw getException("Author Name is empty");
			} else if (data.getFirstName().equals(updatedData.getFirstName())) {
				throw getException("Protegrity Api sent same data for FirstName");
			}
		}
	}

	private ProtegrityException getException(String string) {
		
		return new ProtegrityException(string);
	}
}
