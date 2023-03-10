package com.protegrity.protegritytokdetok.repositories;

import java.util.Date;
import java.util.List;

import com.protegrity.protegritytokdetok.model.ProtegrityFields;

public interface ProtegrityFieldsDAO {
	List<ProtegrityFields> findAll();

	long update(int id, String tokSSN, String tokFirstName,String tokLastName,Date tokDOB,String tokEmail,String tokOtherID);
}
