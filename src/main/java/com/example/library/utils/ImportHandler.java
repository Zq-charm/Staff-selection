package com.example.library.utils;




import org.springframework.beans.BeanUtils;

import com.example.library.Entity.Expert;
import com.example.library.Entity.Model.ExpertModel;
import com.example.library.Repository.ExpertRepository;

/**
 * excel数据导入处理

 */
public class ImportHandler {
    /**
     * 主handler
     * @param model
     * @param resultVO
     * @param repository
     */
    public static void modelExpertHandler(ExpertModel model, ImportResultVO<ExpertModel> resultVO, ExpertRepository repository) {
        /** 过滤表头 多层表头时可以用集合contains过滤，或者stream()*/
        /** 过滤表头，以及空行数据（excel文件某行中曾经有数据，删除数据不行删除的条件下，读取默认都是空） */
        if (!"序号".equals(model.getIndex()) && model.getName() != null && !"".equals(model.getName())) {
            /** 判断数据库是否存在 */
            boolean isExist = repository.findExpertByName(model.getName())!=null;
            if (isExist) {
                modelExist(model,resultVO,repository);
            } else {
                modelNotExist(model,resultVO,repository);
            }
        }
    }


//    /**
//     * 主handler
//     * @param model
//     * @param resultVO
//     * @param repository
//     */
//    public static void modelGraduateHandler(GraduateModel model, ImportResultVO<GraduateModel> resultVO, GraduateInfoRepository repository) {
//        /** 过滤表头 多层表头时可以用集合contains过滤，或者stream()*/
//        /** 过滤表头，以及空行数据（excel文件某行中曾经有数据，删除数据不行删除的条件下，读取默认都是空） */
//        if (!"序号".equals(model.getIndex()) && model.getUserId() != null && !"".equals(model.getUserId())) {
//            /** 判断数据库是否存在 */
//            boolean isExist = repository.existsByUserId(model.getUserId());
//            if (isExist) {
//                modelExist(model,resultVO,repository);
//            } else {
//                modelNotExist(model,resultVO,repository);
//            }
//        }
//    }

    /**
     * 主handler
     * @param model
     * @param repository
     */
    public static void modelHandler(ExpertModel model, ExpertRepository repository) {
        /** 过滤表头 多层表头时可以用集合contains过滤，或者stream()*/
        /** 过滤表头，以及空行数据（excel文件某行中曾经有数据，删除数据不行删除的条件下，读取默认都是空） */
        if (!"序号".equals(model.getIndex()) && model.getName() != null && !"".equals(model.getName())) {
            /** 判断数据库是否存在 */
            boolean isExist = repository.findExpertByName(model.getName())!=null;
            if (!isExist) {
                /** 数据不存在时 如果需要实时覆盖 请删除判断*/
                modelSave(model,repository);
            }
        }
    }

//    /**
//     * 数据重复时处理
//     * @param model
//     * @param resultVO
//     */
//    public static void modelExist(GraduateModel model, ImportResultVO<GraduateModel> resultVO, GraduateInfoRepository repository) {
//        repository.findAllByUserId(model.getUserId()).forEach(graduateInfo -> {
//            BeanUtils.copyProperties(model,graduateInfo);
//            repository.save(graduateInfo);
//        });
//        /** 存在时更新返回结果信息 */
//        if(resultVO.getRepeatList() == null) {
//            resultVO.initRepeatList().add(model);
//        } else {
//            resultVO.getRepeatList().add(model);
//        }
//        resultVO.increaseRepeat();
//    }

    /**
     * 数据重复时处理
     * @param model
     * @param resultVO
     */
    public static void modelExist(ExpertModel model, ImportResultVO<ExpertModel> resultVO, ExpertRepository repository) {
        modelSave(model,repository);
        /** 存在时更新返回结果信息 */
        if(resultVO.getRepeatList() == null) {
            resultVO.initRepeatList().add(model);
        } else {
            resultVO.getRepeatList().add(model);
        }
        resultVO.increaseRepeat();
    }

//    /**
//     * 数据不重复时处理
//     * @param model
//     * @param resultVO
//     * @param repository
//     */
//    public static void modelNotExist(GraduateModel model, ImportResultVO<GraduateModel> resultVO,GraduateInfoRepository  repository) {
//        modelSave(model,repository);
//        resultVO.increaseSuccess();
//    }


    /**
     * 数据不重复时处理
     * @param model
     * @param resultVO
     * @param repository
     */
    public static void modelNotExist(ExpertModel model, ImportResultVO<ExpertModel> resultVO,ExpertRepository  repository) {
        modelSave(model,repository);
        resultVO.increaseSuccess();
    }

    /**
     * 数据保存处理
     * @param model
     * @param repository
     */
    public static void modelSave(ExpertModel model, ExpertRepository repository) {
    	Expert expert = new Expert();
        /** BeanUtils的拷贝方法会拷贝null值覆盖，CopyUtils的拷贝方法不会拷贝null */
        BeanUtils.copyProperties(model,expert);
        checkSex(model,expert);
        repository.save(expert);
    }

//    /**
//     * 数据保存处理
//     * @param model
//     * @param repository
//     */
//    public static void modelSave(GraduateModel model, GraduateInfoRepository repository) {
//        GraduateInfo graduateInfo = new GraduateInfo();
//        /** BeanUtils的拷贝方法会拷贝null值覆盖，CopyUtils的拷贝方法不会拷贝null */
//        BeanUtils.copyProperties(model,graduateInfo);
//        graduateInfo.setGraduateYear(Integer.parseInt(model.getGraduateYear()));
//        repository.save(graduateInfo);
//    }

    /**
     * 性别字段检查
     * @param model
     * @param userInfo
     */
    private static void checkSex(ExpertModel model, Expert expert ) {
        if (model.getSex() != null) {
        	expert.setSex(model.getSex());//SexTypeEnum.analysisContent(model.getSex())
        } else {
        	expert.setSex(SexTypeEnum.DEFAULT.getContent());
        }
    }
}
