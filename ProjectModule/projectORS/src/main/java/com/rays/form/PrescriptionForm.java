package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CollegeDTO;
import com.rays.dto.PrescriptionDTO;





public class PrescriptionForm extends BaseForm{

	
	
	
	@NotEmpty(message="enter name")
	private String name;
	
	@NotEmpty(message="enter decease")
	private String decease;
	
	@NotNull(message="enter date")
	private Date date;
	
	@NotNull(message="enter capacity")
	private Integer capacity;
	
	
	
	
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



	
	@Override
	public BaseDTO getDto() {

	PrescriptionDTO dto = initDTO(new PrescriptionDTO());
	dto.setName(name);
	dto.setDecease(decease);
	dto.setDate(date);
	dto.setCapacity(capacity);

		
	return dto;
	
}
}
