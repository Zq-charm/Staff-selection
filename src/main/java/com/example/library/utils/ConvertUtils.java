package com.example.library.utils;

import com.example.library.Entity.Expert;
import com.example.library.Entity.ExportExpert;
import com.example.library.Entity.Model.ExpertModel;
import com.example.library.Entity.Model.ExportExpertModel;


/**
 * 数据转换工具类
 */
public class ConvertUtils {



    public static ExpertModel userInfo2UserModel(Expert expert) {
        ExpertModel expertModel = new ExpertModel();
        CopyUtils.copyProperties(expert, expertModel);
        checkSex(expert,expertModel);
        return expertModel;
    }

    public static ExportExpertModel userInfo2UserModelBySearch(ExportExpert expert) {
    	ExportExpertModel expertModel = new ExportExpertModel();
        CopyUtils.copyProperties(expert, expertModel);
        //checkSex(expert,expertModel);
        return expertModel;
    }

    /**
     * 性别字段检查
     * @param model
     * @param expert
     */
    private static void checkSex(Expert expert, ExpertModel model) {
        if (expert.getSex() != null) {
            model.setSex(expert.getSex());
        } else {
            model.setSex(SexTypeEnum.DEFAULT.getContent());
        }
    }

}
