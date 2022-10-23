package com.example.demo;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	private String uname;
	private String upassword;
	private String uemail;
	@OneToMany(cascade = CascadeType.ALL)   
    private List<Product> products;  
	
}