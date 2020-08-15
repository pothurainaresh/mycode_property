package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
	List<Student> students;
	
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
		return "Welcome to my Student API";
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		return students;
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id)
	{
		/*
		 * return students.stream().filter(student -> (id==student.getId()))
		 * .findFirst().orElseThrow(()->new
		 * IllegalStateException("Requested record not found"));
		 */
		
		Student stu=null;
		for(Student student:students)
		{
			if(student.getId()==id)
			{
				stu=student;
				break;
			}
		}
		
		if(stu==null)
		{
			throw new StudentNotFoundException(id);
			
		}else
		{
			if(stu.getId()==1)
			{
				throw new RuntimeException("Processing error happened");
			}else
			{
				return new ResponseEntity<Student>(stu,HttpStatus.OK);
			}
		}
	}
	
	@DeleteMapping("/removestudent/{id}")
	public ResponseEntity<?> removeStudent(@PathVariable int id)
	{
		Student stu=null;
		for(Student student:students)
		{
			if(student.getId()==id)
			{
				stu=student;
				break;
			}
		}
		
		if(stu==null)
		{
			throw new StudentNotFoundException(id);
		}else
		{
			students.remove(stu);
			return new ResponseEntity<Student>(stu,HttpStatus.OK);
		}
	}

}
