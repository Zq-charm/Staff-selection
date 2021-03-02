package com.example.library.Entity;

import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExportExpert implements Serializable
{
	
    
   
    private String name;


    private String professionalField;
    

    private Long contactWay;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProfessionalField() {
		return professionalField;
	}


	public void setProfessionalField(String professionalField) {
		this.professionalField = professionalField;
	}


	public Long getContactWay() {
		return contactWay;
	}


	public void setContactWay(Long contactWay) {
		this.contactWay = contactWay;
	}
    
    


}
