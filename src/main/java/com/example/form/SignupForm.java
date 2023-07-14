package com.example.form;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SignupForm {
	@Id
	private int id;
	private String password;
	private String mailaddress;
	private String name;
	private String authority;

}
