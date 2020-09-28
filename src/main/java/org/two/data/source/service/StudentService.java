package org.two.data.source.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.two.data.source.entity.Student;
import org.two.data.source.entity.dto.StudentDTO;
import org.two.data.source.repository.StudentRepository;

@Service
public class StudentService {

	Logger log = LoggerFactory.getLogger(StudentService.class);
	
	DozerBeanMapper mapper = new DozerBeanMapper();
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}
	
	public StudentDTO findById(long id) {
		
		Student student = studentRepository.findById(id).get(); 
		StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
		return studentDTO;
	}
	
	public StudentDTO add(StudentDTO studentDTO) {
		
		Student student =  mapper.map(studentDTO, Student.class);
		Student save = studentRepository.save(student);
		return mapper.map(save, StudentDTO.class);
	}
}