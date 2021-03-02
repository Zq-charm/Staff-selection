package com.example.library.utils;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Getter
public enum ResponseResultEnum {
    EXCEL_FILE_EXT_ERROR(1000,"文件格式错误"),
    EXCEL_FILE_READ_FAIL(1001,"excel文件读取失败"),
    EXCEL_FILE_IS_EMPTY(1002,"excel文件为空"),
    MODEL_FILE_NOT_EXIT(1003,"模版文件不存在"),
    ;

    private Integer status;
    private String message;

    ResponseResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    

}
