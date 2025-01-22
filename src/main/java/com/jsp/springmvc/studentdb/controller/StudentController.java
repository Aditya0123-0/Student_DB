package com.jsp.springmvc.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc.studentdb.entity.Student;
import com.jsp.springmvc.studentdb.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/add-student", method = RequestMethod.POST)
	public ModelAndView addStudent(Student student) {
		
		return studentService.addStudent(student);
		
	}
	
	@RequestMapping(value = "/find-all-student", method = RequestMethod.GET)
	public ModelAndView displayStudent() {
		return studentService.displayStudent();
	}
	
	@RequestMapping(value="/find-student-by-id", method = RequestMethod.GET)
	public ModelAndView findStudentById(int studentId) {
		return studentService.findStudentById(studentId);
	}
	
	@RequestMapping(value = "/update-student", method = RequestMethod.POST)
	public ModelAndView updateStudent(Student student) {
		return studentService.updateStudent(student);
	}
	
	@RequestMapping(value = "/delete-student-by-id", method = RequestMethod.GET)
	public ModelAndView deleteStudent(int studentId) {
		return studentService.deleteStudent(studentId);
	}
}
