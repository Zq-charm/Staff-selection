package com.example.library.Entity.Model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExportExpertModel extends BaseRowModel
{
	   /** 从第几行开始写入数据 */
    @Ignore
    private Integer startRow = 9;

    @ExcelProperty(value = "序号" ,index = 1)
    private String index;
    
    
    @ExcelProperty(value = "姓名" ,index = 2)
    private String name;

    @ExcelProperty(value = "专业领域方向" ,index = 3)
    private String professionalField;
    
    @ExcelProperty(value = "联系方式" ,index = 4)
    private Long contactWay;

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

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
