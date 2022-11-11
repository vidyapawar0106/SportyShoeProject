package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	
	private int id;
	private String pname;
	private String company;
	private String psize;
	private String catagory;
	private int price;

}
