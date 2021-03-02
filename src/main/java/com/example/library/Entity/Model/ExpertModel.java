package com.example.library.Entity.Model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 专家信息excel模板对应model
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ExpertModel extends BaseRowModel {
    /** 从第几行开始写入数据 */
    @Ignore
    private Integer startRow = 1;

    @ExcelProperty(value = "序号" ,index = 0)
    private String index;
    
    
    @ExcelProperty(value = "姓名" ,index = 1)
    private String name;

    @ExcelProperty(value = "性别" ,index = 2)
    private String sex;

    @ExcelProperty(value = "职称" ,index = 3)
    private String grade;

    @ExcelProperty(value = "工作单位" ,index = 4)
    private String organization;

    @ExcelProperty(value = "是否为涉密人员" ,index =5)
    private String classified;

    @ExcelProperty(value = "校内外专家" ,index = 6)
    private String inOrOutSchool;

    @ExcelProperty(value = "专业领域" ,index = 7)
    private String professionalField;
    
    @ExcelProperty(value = "学科方向" ,index = 8)
    private String subjectDirection;
    
    @ExcelProperty(value = "联系方式" ,index = 9)
    private Long contactWay;
    
    @ExcelProperty(value = "备注" ,index = 10)
    private String remark;



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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}





	public String getClassified() {
		return classified;
	}

	public void setClassified(String classified) {
		this.classified = classified;
	}

	public String getInOrOutSchool() {
		return inOrOutSchool;
	}

	public void setInOrOutSchool(String inOrOutSchool) {
		this.inOrOutSchool = inOrOutSchool;
	}

	public String getProfessionalField() {
		return professionalField;
	}

	public void setProfessionalField(String professionalField) {
		this.professionalField = professionalField;
	}

	public String getSubjectDirection() {
		return subjectDirection;
	}

	public void setSubjectDirection(String subjectDirection) {
		this.subjectDirection = subjectDirection;
	}



	public Long getContactWay() {
		return contactWay;
	}

	public void setContactWay(Long contactWay) {
		this.contactWay = contactWay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}




    
}