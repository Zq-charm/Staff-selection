package com.example.library.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.Entity.Expert;
import com.example.library.Entity.ExportExpert;
import com.example.library.Entity.Model.ExpertModel;
import com.example.library.Entity.Model.ExportExpertModel;
import com.example.library.Repository.ExpertRepository;
import com.example.library.utils.ConvertUtils;
import com.example.library.utils.ExcelException;
import com.example.library.utils.ExcelFileEnum;
import com.example.library.utils.ExcelUtils;
import com.example.library.utils.FileUtils;
import com.example.library.utils.ImportHandler;
import com.example.library.utils.ImportResultVO;
import com.example.library.utils.ResponseResultEnum;
import com.example.library.utils.SexTypeEnum;
import com.example.library.utils.StreamUtils;


@Transactional
@Service("expertService")
public class ExpertServiceImpl implements ExpertService
{
    @Autowired
    private ExpertRepository expertRepository;

	@Override
	public List<Expert> expertsList() {
		List<Expert> expertList = expertRepository.findAll();
		return expertList;
	}

	@Override
	public Expert findExpertById(Long id) {
		
		return expertRepository.findExpertById(id);
	}

	@Override
	public Expert addOneExpert(Expert expert) {
		
		return expertRepository.save(expert);
	}

	@Override
	public Expert updateOneExpert(Expert expert) {
		
		return expertRepository.save(expert);
	}

	@Override
	public void deleteOneExpert(Long id) {
		
		expertRepository.deleteById(id);;
	}

	@Override
	public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(Integer radomnum,
			String classified, String inoroutschool, String professionalfield, String subjectdirection) {
		
		return expertRepository.findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(radomnum,classified, inoroutschool, professionalfield, subjectdirection);
	}
	
	@Override
	public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndNotSubjectDirection(Integer radomnum,
			String classified, String inoroutschool, String professionalfield, String subjectdirection) {
		
		return expertRepository.findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndNotSubjectDirection(radomnum,classified, inoroutschool, professionalfield, subjectdirection);
	}

	@Override
	public ImportResultVO importExpert(MultipartFile excel) {
	        List<ExpertModel> expertModelList;
	        ImportResultVO<ExpertModel> resultVO = new ImportResultVO<>();
	        try {
	        	expertModelList = ExcelUtils.readModelExcel(ExpertModel.class,excel);  //1.读模型和上传的EXCEL
	        } catch (IOException e) {
	            throw new ExcelException(ResponseResultEnum.EXCEL_FILE_READ_FAIL);
	        }
	        if (expertModelList == null || expertModelList.size() == 0) {
	            throw new ExcelException(ResponseResultEnum.EXCEL_FILE_IS_EMPTY);
	        }
	        expertModelList.forEach(model -> ImportHandler.modelExpertHandler(model,resultVO,expertRepository));//2.赋值
	        return resultVO;
	    }

	
	//导出专家信息
	    @Override
	    public void exportExpert(HttpServletResponse response) {
	        String fileName = "expertsDownLoad";
	        File model = FileUtils.createFile("expertsDownLoadModel", ExcelFileEnum.MODEL);
	        File temp = FileUtils.createFile("expertsDownLoadModel", ExcelFileEnum.TEMP);
	        File export = FileUtils.createFile(fileName, ExcelFileEnum.EXPORT);
	        if (!model.isFile() || !model.exists()) {
	            throw new ExcelException(ResponseResultEnum.MODEL_FILE_NOT_EXIT);
	        }
	        /** 先复制模板修改成要生成的形式 */
	        FileUtils.copyFile(model,temp);
	        FileUtils.copyFile(temp,export);
	        ExcelUtils.writeModelWorkBook(temp,export,false);
	        List<Expert> expertList = expertRepository.findAll();
	        List<ExpertModel> expertModelList = new ArrayList<>();
	        for (int index = 0; index < expertList.size(); index++ ) {
	            Expert expert = expertList.get(index);
	            ExpertModel expertModel = ConvertUtils.userInfo2UserModel(expert);
	            expertModel.setIndex(String.valueOf(index+1));
	            expertModelList.add(expertModel);
	        }
	        ExcelUtils.writeUserModelExport(expertModelList,temp,export);
	        StreamUtils.file2Response(fileName,response,export);
	        FileUtils.clearFile(temp);
	        FileUtils.clearFile(export);

	    }

		//导出专家信息
	    @Override
	    public void exportExpertBySearch(HttpServletResponse response,List<ExportExpert> experts) {
	        String fileName = "expertsDownLoad";
	        File model = FileUtils.createFile("expertsDownLoadModel", ExcelFileEnum.MODEL);
	        File temp = FileUtils.createFile("expertsDownLoadModel", ExcelFileEnum.TEMP);
	        File export = FileUtils.createFile(fileName, ExcelFileEnum.EXPORT);
	        if (!model.isFile() || !model.exists()) {
	            throw new ExcelException(ResponseResultEnum.MODEL_FILE_NOT_EXIT);
	        }
	        /** 先复制模板修改成要生成的形式 */
	        FileUtils.copyFile(model,temp);
	        FileUtils.copyFile(temp,export);
	        ExcelUtils.writeModelWorkBook(temp,export,false);
	        List<ExportExpert> expertList = experts;
	        List<ExportExpertModel> expertModelList = new ArrayList<>();
	        for (int index = 0; index < expertList.size(); index++ ) {
	            ExportExpert expert = expertList.get(index);
	            ExportExpertModel expertModel = ConvertUtils.userInfo2UserModelBySearch(expert);
	            expertModel.setIndex(String.valueOf(index+1));
	            expertModelList.add(expertModel);
	        }
	        ExcelUtils.writeUserModelExportBySearch(expertModelList,temp,export);
	        StreamUtils.file2Response(fileName,response,export);
	        FileUtils.clearFile(temp);
	        FileUtils.clearFile(export);

	    }

	    public List<String> findAllSubjectDirectionByProfessionaField(String professionaField)
	    {
	    	return expertRepository.findAllSubjectDirectionByProfessionaField( professionaField);
	    }





//	    @Override
//	    public void exportSex(HttpServletResponse response) {
//	        String fileName = "分类信息";
//	        File model = FileUtils.createFile("分类信息模板", ExcelFileEnum.MODEL);
//	        File temp = FileUtils.createFile("分类信息模板", ExcelFileEnum.TEMP);
//	        File export = FileUtils.createFile(fileName, ExcelFileEnum.EXPORT);
//	        if (!model.isFile() || !model.exists()) {
//	            throw new ExcelException(ResponseResultEnum.MODEL_FILE_NOT_EXIT);
//	        }
//	        /** 先复制模板修改成要生成的形式 */
//	        FileUtils.copyFile(model,temp);
//	        FileUtils.copyFile(temp,export);
//	        List<SexTypeEnum> sexTypeEnumList = Arrays.asList(SexTypeEnum.values());
//	        List<Map<String,String>> nameList = new ArrayList<>();
//	        List<List<Expert>> usersList = new ArrayList<>();
//	        /** 做一个示例 按性别导出 */
//	        sexTypeEnumList.forEach(sexTypeEnum -> {
//	            List<Expert> userList = expertRepository.findAllBySex(sexTypeEnum.getCode());
//	            if (userList.size() > 0) {
//	                Map<String,String> nameMap = new HashMap<>();
//	                nameMap.put("sex",sexTypeEnum.getContent());
//	                nameList.add(nameMap);
//	                usersList.add(userList);
//	            }
//	        });
//	        ExcelUtils.writeModelCloneSheet(temp,export,nameList);
//	        FileUtils.copyFile(export,temp);
//	        ExcelUtils.writeUserExport(usersList,temp,export);
//	        StreamUtils.file2Response(fileName,response,export);
//	        FileUtils.clearFile(temp);
//	        FileUtils.clearFile(export);
//
//	    }

}
