package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "items")//データベース内のテーブル名を指定
public class ItemList{
	
	@Id
	private int id;
	private String items;

}
