package ru.michaelarshinov.soft.club.test.task.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="\"Operation\"")
public class Operation {
	@Id
	@GeneratedValue
	Integer id;
	
	@Column
	Date date;
	
	@Column
	Date createdDate;
	
	@Column
	String description;
	
	@Column
	Double value;
}
