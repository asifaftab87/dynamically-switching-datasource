package org.two.data.source.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.two.data.source.controller.StudentController;
import org.two.data.source.entity.dto.StudentDTO;
import org.two.data.source.service.StudentService;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	static Logger log = LoggerFactory.getLogger(StudentControllerTest.class);
	
	@Autowired 
	MockMvc mvc;
	
	@InjectMocks
	StudentController studentController;
	
	@MockBean
	StudentService studentService;
	
	StudentDTO studentDTO;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		studentDTO = new StudentDTO(90, "sbr90", "snr90");
	}
	
	@Test
	final void testGetUser() {
		
		when(studentService.findById(1)).thenReturn(studentDTO);
		ResponseEntity<StudentDTO> responseEntity = studentController.findById(1);
		StudentDTO body = responseEntity.getBody();
		
		assertNotNull(body);
		assertEquals(studentDTO.getId(), body.getId());
		assertEquals(studentDTO.getName(), body.getName());
	}
	
	@Test
	final void testPutUser() throws Exception {
		
		when(studentService.add(Mockito.any(StudentDTO.class))).thenReturn(studentDTO);
		
		log.info("studentDTO: "+studentDTO);
		log.info("mvc: "+mvc);
		
		
		mvc.perform(post("/student/add")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(toJson(studentDTO)))
	            .andExpect(status().isAccepted());
	            
	}
	
	 public static String toJson(final Object obj) {
		 
	        try {
	        	String json = new ObjectMapper().writeValueAsString(obj);
	        	log.info("json: "+json);
	            return json;
	        } 
	        catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	
}
