package com.protegrity.protegritytokdetok.model;


import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection="")
public class ProtegrityFields {
	private int id;
	private String SSN;
	private String firstName;
	private String lastName;
	private Date DOB;
	private String Email;
	private String OtherID;
}
