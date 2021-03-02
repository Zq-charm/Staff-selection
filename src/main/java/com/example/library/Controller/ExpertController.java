package com.example.library.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.Entity.Expert;
import com.example.library.Entity.ExportExpert;
import com.example.library.Repository.ExpertRepository;
import com.example.library.Service.ExpertService;
import com.example.library.utils.ResponseResult;
import com.example.library.utils.ResponseResultUtils;

@RestController
public class ExpertController  {

    @Autowired
    private ExpertService expertService;
	
    //查询专家列表
    @GetMapping(value = "/experts")
    public List<Expert> expertsList()
    {
        return expertService.expertsList();
    }
    

    //查询一个专家
    @GetMapping(value = "/experts/{id}")
    public Expert expertFindOne(@PathVariable("id") Long id)
    {

        return expertService.findExpertById(id);//.orElse(null)
    }

    
    //添加一个专家
    @PostMapping(value = "/experts")
    @ResponseBody
    public Expert expertAdd( @RequestBody @Valid Expert expert)
    {
        return expertService.addOneExpert(expert);
    }


    //更新一个专家
    @PutMapping(value = "/experts/{id}") //Expert需要传主键
    @ResponseBody
    public Expert expertUpdate(@PathVariable("id") Long expert_id, @RequestBody @Valid Expert expert)
    {
    	
        return expertService.updateOneExpert(expert);
    }

    //删除一个专家
    @DeleteMapping(value = "/experts/{id}")
    public void expertdelet(@PathVariable("id") Long id)
    {
    	expertService.deleteOneExpert(id);
    }
    
    //精确+模糊，多条件查找，根据是否涉密是否校内外专业领域精确+学科方向模糊查找
    @GetMapping(value="/expertListsOptions")
    public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(@RequestParam(value="radomnum",required=false) Integer radomnum,@RequestParam(value = "classified",required=false)String classified,@RequestParam(value="inoroutschool",required=false) String inoroutschool, @RequestParam(value= "professionalfield",required = false)String professionalfield,@RequestParam(value="subjectdirection",required=false) String subjectdirection)
    {
    	 	
    	return expertService.findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(radomnum,classified, inoroutschool, professionalfield, subjectdirection);
    	   
    }
    
    
    //精确+模糊，多条件查找，根据是否涉密是否校内外专业领域精确+排除学科方向精确查找
    @GetMapping(value="/expertListsOptions/1")
    public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndNotSubjectDirection(@RequestParam(value="radomnum",required=false) Integer radomnum,@RequestParam(value = "classified",required=false)String classified,@RequestParam(value="inoroutschool",required=false) String inoroutschool, @RequestParam(value= "professionalfield",required = false)String professionalfield,@RequestParam(value="subjectdirection",required=false) String subjectdirection)
    {
    	 	
    	return expertService.findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndNotSubjectDirection(radomnum,classified, inoroutschool, professionalfield, subjectdirection);
    	   
    }
    
    //换一批
    @RequestMapping(value="/expertListsOptions/next")
    @ResponseBody
    public List<Expert> nextlist(@RequestParam(value="radomnum",required=false) Integer radomnum,@RequestParam(value = "classified",required=false)String classified,@RequestParam(value="inoroutschool",required=false) String inoroutschool, @RequestParam(value= "professionalfield",required = false)String professionalfield,@RequestParam(value="subjectdirection",required=false) String subjectdirection,@RequestBody @Valid List<Expert> oldexperts)
    {
    	 	
    	List<Expert> newexpertList =new ArrayList<Expert>();
//    	newexpertList=expertService.findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(radomnum,classified, inoroutschool, professionalfield, subjectdirection);
//    	
    	List<Expert> allexpertList=new ArrayList<Expert>();
    	while(allexpertList.size()<radomnum)
    	{
    		newexpertList=expertService.findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(radomnum-allexpertList.size(),classified, inoroutschool, professionalfield, subjectdirection);
    		//System.out.print("new="+newexpertList.get(0).getName());
    		newexpertList.removeAll(oldexperts);
    		
    		//System.out.print("remove="+newexpertList.get(0).getName());
    		allexpertList.addAll(newexpertList);
    		//System.out.print("all="+allexpertList.get(0).getName());
    	}
    	return allexpertList;    	
    }
    
    /**
     * 导入专家Excel文件
     * @param excel
     * @return
     */
    @PostMapping("/importExpert")
    public ResponseResult importUser(@RequestParam("excel") MultipartFile excel) {
        return ResponseResultUtils.success("导入成功",expertService.importExpert(excel));
    }
    
    
    /**
     * 导出个人Excel文件
     * @param response
     */
    @GetMapping("/exportExpert")
    public void exportUser(HttpServletResponse response) {
    	response.setHeader("Content-Disposition", "attachment;filename=expertsDownLoad.xlsx");
    	response.setHeader("Content-Type", "application/octet-stream");
        expertService.exportExpert(response);
    }
    
    /**
     * 导出个人Excel文件
     * @param response
     */
    @RequestMapping("/exportExpertBySearch")
    @ResponseBody
    public void exportUserBySearch(HttpServletResponse response,@RequestBody @Valid List<Expert> experts) {
    	response.setHeader("Content-Disposition", "attachment;filename=expertsDownLoad.xlsx");
    	response.setHeader("Content-Type", "application/octet-stream");
    	List<ExportExpert> exportexperts= new ArrayList<ExportExpert>();
    	for(int i=0;i<experts.size();i++)
    	{
    		ExportExpert exportexpert = new ExportExpert();
    		exportexpert.setName(experts.get(i).getName());
    		exportexpert.setProfessionalField(experts.get(i).getProfessionalField());
    		exportexpert.setContactWay(experts.get(i).getContactWay());
    		exportexperts.add(exportexpert);
    	}
        expertService.exportExpertBySearch(response,exportexperts);
    }
    
    //根据专业领域查找不重复的学科方向
    @RequestMapping(value="/professionaField/allSubjectDirection")
    @ResponseBody
    public List<String> allSubjectDirection(@RequestParam(value="professionaField",required=true)String professionalField )
    {
    	return expertService.findAllSubjectDirectionByProfessionaField( professionalField);
    	
    }
    
}
