package com.example.library.utils;

import lombok.Getter;

/**
 * 全局异常
 */
@Getter
public class ExcelException extends RuntimeException {

    private Integer status;

    public ExcelException(ResponseResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
    }

    public ExcelException(Integer status, String message) {
        super(message);
        this.status = status;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
