package com.example.library.Service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.Entity.Expert;
import com.example.library.Entity.ExportExpert;
import com.example.library.Repository.ExpertRepository;
import com.example.library.utils.ImportResultVO;


public interface ExpertService
{
	 public List<Expert> expertsList();
	 
	 public Expert findExpertById(Long id);
	 
	 public Expert addOneExpert(Expert expert);
	 
	 public Expert updateOneExpert(Expert expert);
	 
	 public void deleteOneExpert(Long id);
	 
	 public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(Integer radomnum,String classified,String inoroutschool,String professionalfield,String subjectdirection);
	 
	 public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndNotSubjectDirection(Integer radomnum,String classified,String inoroutschool,String professionalfield,String subjectdirection);
	 
	 public List<String> findAllSubjectDirectionByProfessionaField(String professionaField);
	    /**
	     * 导入专家信息
	     * @param excel
	     */
	    ImportResultVO importExpert(MultipartFile excel);

	    /**
	     * 导出专家信息
	     * @param response
	     */
	    void exportExpert(HttpServletResponse response);


	    void exportExpertBySearch(HttpServletResponse response,List<ExportExpert> exportexperts);


//	    /**
//	     * 按性别分别导出专家信息
//	     * @param response
//	     */
//	    void exportSex(HttpServletResponse response);
}
