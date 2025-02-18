package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

import com.rays.common.BaseDTO;


@Entity
@Table(name="ST_PRESCRIPTION")
public class PrescriptionDTO extends BaseDTO {

	
	
	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "DECEASE", length = 50)
	private String decease;
	
	@Column(name = "DATE", length = 50)
	private Date date;
	
	@Column(name = "CAPACITY", length = 50)
	private Integer capacity;
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Name";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("name", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("name", name);
		return map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecease() {
		return decease;
	}

	public void setDecease(String decease) {
		this.decease = decease;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	

}
