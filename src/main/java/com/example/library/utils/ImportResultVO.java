package com.example.library.utils;

import java.util.ArrayList;
import java.util.List;

public class ImportResultVO<T> 
{
    /** 成功数量 */
    private Integer success = 0;
    /** 失败数量 */
    private Integer failure = 0;
    /** 重复数量 */
    private Integer repeat = 0;
    /** 失败数据 */
    private List<T> failureList;
    /** 重复数据 */
    private List<T> repeatList;

    public List<T> initFailureList() {
        this.failureList = new ArrayList<>();
        return this.failureList;
    }

    public List<T> initRepeatList() {
        this.repeatList = new ArrayList<>();
        return this.repeatList;
    }

    public synchronized void increaseSuccess() {
        this.success++;
    }

    public synchronized void increaseFailure() {
        this.failure++;
    }

    public synchronized void increaseRepeat() {
        this.repeat++;
    }

	public Integer getSuccess() {
		return success;
	}

	public void setSuccess(Integer success) {
		this.success = success;
	}

	public Integer getFailure() {
		return failure;
	}

	public void setFailure(Integer failure) {
		this.failure = failure;
	}

	public Integer getRepeat() {
		return repeat;
	}

	public void setRepeat(Integer repeat) {
		this.repeat = repeat;
	}

	public List<T> getFailureList() {
		return failureList;
	}

	public void setFailureList(List<T> failureList) {
		this.failureList = failureList;
	}

	public List<T> getRepeatList() {
		return repeatList;
	}

	public void setRepeatList(List<T> repeatList) {
		this.repeatList = repeatList;
	}
    
    

}
