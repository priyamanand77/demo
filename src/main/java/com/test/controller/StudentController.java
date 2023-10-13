package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Student;
import com.test.repo.StudentRepo;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	
	@GetMapping("/test")
	public String test()
	{
		return "Hello Bunty";
	}
	
	//1 . Student -> all get 
	
	
//JPA
	@GetMapping("/getAll")
	public List<Student> getAllStudentFromDataBAse()
	{
		
		List<Student> students = repo.findAll();
		return students;
		
	}
	
	
	
	
	// insert values inside table 
	@PostMapping("/insert")
	public Student insertStudent(@RequestBody Student student)
	{
	
		Student save = repo.save(student);
		
		return save;
		
	}
	
	@PutMapping("/update/{roll}")
	public String updateStudent(@RequestBody Student student , @PathVariable(name = "roll") int roll)
	{
			Student student2 = repo.findById(roll).get();
			
			student2.setGender(student.getGender());
			student2.setName(student.getName());
			
			Student save = repo.save(student2);
			return save.toString();
			
			
	}
	
	@DeleteMapping("/delete/{roll}")
	public String deleteStudent( @PathVariable(name = "roll") int roll)
	{
		repo.deleteById(roll);
		return "deleted";
	}
	
	@GetMapping("/getMale")
	public List<Student> getAllMale()
	{
		return repo.findByGender("male");
		
	}
	
	@GetMapping("/getFemale")
	public List<Student> getAllFeMale()
	{
		return repo.findByGender("female");
		
	}
	
	@GetMapping("/getName/{name}")
	public List<Student> getName(@PathVariable String name)
	{
		return repo.findByName(name);
		
	}
	
	
	
	

}
