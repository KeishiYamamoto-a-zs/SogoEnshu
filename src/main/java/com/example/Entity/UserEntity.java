package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity  //データベースのテーブルとマッピングするクラスにつける
@Table(name = "user_info")//データベース内のテーブル名を指定
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String password;
	private String mailaddress;
	private String name;
	private String authority;
	

}
