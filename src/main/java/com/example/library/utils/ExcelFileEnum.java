package com.example.library.utils;

import lombok.Getter;


@Getter
public enum ExcelFileEnum {
    MODEL(1,"model"),
    TEMP(2,"temp"),
    EXPORT(3,"export"),
    ;
    private String content;
    private Integer code;

    ExcelFileEnum(Integer code, String content) {
        this.code = code;
        this.content = content;
    }

    ExcelFileEnum(ExcelFileEnum excelFileEnum) {
        this.code = excelFileEnum.getCode();
        this.content = excelFileEnum.getContent();
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
    
    

}
