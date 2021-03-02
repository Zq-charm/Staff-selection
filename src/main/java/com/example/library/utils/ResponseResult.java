package com.example.library.utils;
import lombok.Data;

//返回体

@Data
public class ResponseResult<T> {
    /** 错误码 */
    private Integer status;
    /** 信息 */
    private String message;
    /** 内容 */
    private T data;
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
    
    
}
