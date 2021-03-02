package com.example.library.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Expert implements Serializable {
	@Id
	@GeneratedValue // 自增
	@Column(name = "id", nullable = false)
	private long id;

	@NotBlank(message = "该字段必传")
	private String name;

	/// * 用户性别，1：男，2：女
	private String sex;

	private String grade;// 职称

	private String organization;// 工作单位

	private String classified; // 是否涉密，否： 不涉密，是： 涉密

	private String inOrOutSchool; // 校内校外专家，是 ：校内 ，否：校外

	private String professionalField; // 专业领域 固定选项，精确查找

	private String subjectDirection; // 学科方向 自填 ，模糊查找

	private Long contactWay;// 联系方式

	private String related_department;

	public String getRelated_department() {
		return related_department;
	}

	public void setRelated_department(String related_department) {
		this.related_department = related_department;
	}

	private String remark;// 备注

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classified == null) ? 0 : classified.hashCode());
		result = prime * result + ((contactWay == null) ? 0 : contactWay.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((inOrOutSchool == null) ? 0 : inOrOutSchool.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((professionalField == null) ? 0 : professionalField.hashCode());
		result = prime * result + ((related_department == null) ? 0 : related_department.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((subjectDirection == null) ? 0 : subjectDirection.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expert other = (Expert) obj;
		if (classified == null) {
			if (other.classified != null)
				return false;
		} else if (!classified.equals(other.classified))
			return false;
		if (contactWay == null) {
			if (other.contactWay != null)
				return false;
		} else if (!contactWay.equals(other.contactWay))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (id != other.id)
			return false;
		if (inOrOutSchool == null) {
			if (other.inOrOutSchool != null)
				return false;
		} else if (!inOrOutSchool.equals(other.inOrOutSchool))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (professionalField == null) {
			if (other.professionalField != null)
				return false;
		} else if (!professionalField.equals(other.professionalField))
			return false;
		if (related_department == null) {
			if (other.related_department != null)
				return false;
		} else if (!related_department.equals(other.related_department))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (subjectDirection == null) {
			if (other.subjectDirection != null)
				return false;
		} else if (!subjectDirection.equals(other.subjectDirection))
			return false;
		return true;
	}


	
	

}
