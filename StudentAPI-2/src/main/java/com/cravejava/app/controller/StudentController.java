package com.cravejava.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cravejava.app.model.Student;

@RestController
public class StudentController 
{
	private List<Student> students;
	
	public StudentController()
	{
		students=new ArrayList<Student>();
		students.add(new Student(1, "Ava", "Jacob", 10, "AJ@cravejava.in"));
		students.add(new Student(2, "Brooklyn", "Logan", 20, "BL@cravejava.in"));
		students.add(new Student(3, "Christopher", "James", 30, "CJ@cravejava.in"));
		students.add(new Student(4, "Daniel", "Liam", 40, "DL@cravejava.in"));
		students.add(new Student(5, "Evelyn", "Ryan", 50, "ER@cravejava.in"));
	}
	
	@GetMapping
	public String welcome()
	{
		return "Welcome to my student API";
	}
	
	@GetMapping(path="/students",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Student> getAllStudents()
	{
		return students;
	}
	
	@GetMapping(path="/student/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Student getStudentById(@PathVariable int id)
	{
		//return students.stream().filter(student -> (id==student.getStudentId())).findFirst().orElseThrow(()->new IllegalStateException("Student with the id:"+id+" not found"));
		Student stu=null;
		
		for(Student student:students)
		{
			if(id==student.getStudentId())
			{
				stu=student;
				break;
			}
		}
		
		if(null==stu)
		{
			throw new IllegalStateException("Student with the id:"+id+" not found");
		}
		
		return stu;
	}
	
	@PostMapping(path="/addstudent",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Student> addStudent(@RequestBody Student student)
	{
		students.add(student);
		return students;
	}
	
	@DeleteMapping("/removestudent/{id}")
	public List<Student> deleteStudent(@PathVariable int id)
	{
		Student stu= students.stream().filter(student -> (id==student.getStudentId())).findFirst().orElseThrow(()->new IllegalStateException("Student with the id:"+id+" not found"));
		students.remove(stu);
		return students;
	}
	
	@PutMapping(path="/updatestudent",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Student> updateStudent(@RequestBody Student student)
	{
		students.add(student);
		return students;
	}

}
