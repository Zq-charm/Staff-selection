package com.example.library.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Expert;

@Repository
public interface ExpertRepository extends JpaRepository<Expert,Long>, JpaSpecificationExecutor<Expert>
{
	 
    
	public Expert findExpertById(Long id);
	public Expert findExpertByName(String name);
	//if(?1 !='',x1=?1,1=1)
	// @Query(value = "select * from expert as e where (e.classified=:classified or e.classified=null) and (e.in_or_out_school=:inoroutschool or e.in_or_out_school=null ) and (e.professional_field=:professionalfield or e.professional_field=null) and e.subject_direction like CONCAT('%',:subjectdirection,'%') order by rand() limit :radomnum",nativeQuery = true)
	
	 @Query(value = "select * from expert as e where if(:classified !='',e.classified=:classified, 1=1) and if(:inoroutschool !='',e.in_or_out_school=:inoroutschool, 1=1) and if(:professionalfield !='',e.professional_field=:professionalfield, 1=1) and if(:subjectdirection !='',e.subject_direction like CONCAT('%',:subjectdirection,'%'), 1=1)  order by rand() limit :radomnum",nativeQuery = true)
	//public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(Integer classified,Integer inoroutschool, String professionalfield,@Param("subjectdirection") String subjectdirection);
	public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndSubjectDirection(@Param("radomnum") Integer radomnum,@Param("classified")String classified, @Param("inoroutschool")String inoroutschool,@Param("professionalfield") String professionalfield,@Param("subjectdirection") String subjectdirection);

	 @Query(value = "select * from expert as e where if(:classified !='',e.classified=:classified, 1=1) and if(:inoroutschool !='',e.in_or_out_school=:inoroutschool, 1=1) and if(:professionalfield !='',e.professional_field=:professionalfield, 1=1) and if(:subjectdirection !='',e.subject_direction !=:subjectdirection, 1=1)  order by rand() limit :radomnum",nativeQuery = true)
	 public List<Expert> findExpertByClassifiedAndInOrOutSchoolAndProfessionalFieldAndNotSubjectDirection(@Param("radomnum") Integer radomnum,@Param("classified")String classified, @Param("inoroutschool")String inoroutschool,@Param("professionalfield") String professionalfield,@Param("subjectdirection") String subjectdirection);
	
	 @Query(value = "select distinct(subject_direction) from expert as e where if(:professionalField !='',e.professional_field=:professionalField, 1=1)",nativeQuery = true)
	 public List<String> findAllSubjectDirectionByProfessionaField(@Param("professionalField")String professionaField);
}
