package com.example.form;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InputForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "文字を入力してください")
	@Size(min = 0, max = 4, message = "1～4文字以内で入力してください")
	private String items;
	
	@NotBlank(message = "文字を入力してください")
	@Size(min = 0, max = 4, message = "1～4文字以内で入力してください")
	private String farmer;
	
	@NotBlank(message = "文字を入力してください")
	@Size(min = 0, max = 4, message = "1～4文字以内で入力してください")
	private String area;
	
}
