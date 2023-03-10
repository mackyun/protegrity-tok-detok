package com.protegrity.protegritytokdetok.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.client.result.UpdateResult;
import com.protegrity.protegritytokdetok.model.ProtegrityFields;
import org.springframework.stereotype.Repository;

@Repository
public class ProtegrityFieldsRespository  implements ProtegrityFieldsDAO{

	@Autowired
	 MongoTemplate mongoTemplate;
	
	@Override
	public List<ProtegrityFields> findAll() {
	
		return mongoTemplate.findAll(ProtegrityFields.class);
	}

	@Override
	public long update(int id, String tokSSN, String tokFirstName, String tokLastName, Date tokDOB, String tokOtherID,
			String tokEmail) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		
		Update updateQuery = new Update();
		updateQuery.set("SSN",tokSSN);
		updateQuery.set("firstName",tokFirstName);
		updateQuery.set("lastName",tokLastName);
		updateQuery.set("DOB",tokDOB);
		updateQuery.set("OtherID",tokOtherID);
		updateQuery.set("Email",tokEmail);
		
		
	UpdateResult result=	mongoTemplate.updateFirst(query, updateQuery,ProtegrityFields.class );
	return result.getModifiedCount();
	}

}
