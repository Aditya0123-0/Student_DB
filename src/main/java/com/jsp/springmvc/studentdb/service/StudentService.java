package com.jsp.springmvc.studentdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc.studentdb.entity.Student;
import com.jsp.springmvc.studentdb.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public ModelAndView addStudent(Student student) {
//		Process Request: Saving student to database
		studentRepository.addStudent(student);
		
//		Process Responce - return back to Dashboard
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.jsp");
		
		return modelAndView;
	}
	
	public ModelAndView displayStudent() {
		
		List<Student> displayStudent = studentRepository.displayStudent();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("DisplayAllStudent.jsp");
		modelAndView.addObject("studentList",displayStudent);
		
		return modelAndView;
	}
	


	public ModelAndView findStudentById(int studentId) {
	    
		Student student= studentRepository.findStudentById(studentId);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateStudent.jsp");
		modelAndView.addObject("student",student);
		
		return modelAndView;
	}

	public ModelAndView updateStudent(Student student) {
		
		studentRepository.updateStudent(student);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:find-all-student");
		
		return modelAndView;
	}
	
	public ModelAndView deleteStudent(int studentId) {
		
		studentRepository.deleteStudent(studentId);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:find-all-student");
		
		return modelAndView;
	}

}
