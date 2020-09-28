package org.two.data.source.controller;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.two.data.source.entity.Student;
import org.two.data.source.entity.dto.StudentDTO;
import org.two.data.source.service.StudentService;

@RestController
public class StudentController {

	Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;

	DozerBeanMapper mapper = new DozerBeanMapper();
	
	@GetMapping(value = "student")
	public ResponseEntity<List<Student>> getStudents() {
		
		log.info("------------------------Student controller get controller-------------------------");
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(studentService.getStudents());
	}
	
	@PostMapping(value = "student")
	public ResponseEntity<List<Student>> setStudents() {
		
		log.info("------------------------Student controller post controller-------------------------");
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(studentService.getStudents());
	}
	
	@GetMapping(value = "student/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable("id") long id) {
		
		log.info("------------------------Student controller get controller------------------------- "+id);
		
		StudentDTO studentDTO = studentService.findById(id);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(studentDTO);
	}
	
	@PostMapping(value = "student/add")
	public ResponseEntity<StudentDTO> add(@RequestBody StudentDTO studentDto) {
		
		log.info("add: "+studentDto);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(studentService.add(studentDto));
	}
	
}