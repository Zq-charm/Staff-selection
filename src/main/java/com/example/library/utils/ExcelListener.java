package com.example.library.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * excel数据导入数据处理
 */
@Getter
@Setter
public class ExcelListener<T> extends AnalysisEventListener<T> {

    private List<T> dataList = new ArrayList<>();
    @Override
    public void invoke(T classType, AnalysisContext analysisContext) {
        dataList.add(classType);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
    
    
}