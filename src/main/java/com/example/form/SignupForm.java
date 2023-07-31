package com.example.form;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "文字を入力してください")
	private String password;
	@NotBlank(message = "文字を入力してください")
	private String mailaddress;
	
	private String name;
	@NotBlank(message = "文字を入力してください")
	private String authority;

}
