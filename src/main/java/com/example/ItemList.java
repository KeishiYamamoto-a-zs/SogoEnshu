package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity  //データベースのテーブルとマッピングするクラスにつける
@Table(name = "items")//データベース内のテーブル名を指定
public class ItemList{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String items;
	
	public void setName(String items) {
	    this.items = items;
	}


}
