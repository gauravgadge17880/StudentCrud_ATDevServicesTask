package com.ATDevServiceTask.repo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ATDevServiceTask.model.Student;
import com.ATDevServiceTask.repo.StudentRepo;





@RestController
public class StudentController {
	@Autowired
	private StudentRepo repo;
	

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		Student std= new Student();
		std.setName(student.getName());
		std.setId(student.getId());
		std.setAge(student.getAge());
		std.setCity(student.getCity());
		
		
		return repo.save(std);
	}
	
	@GetMapping("/get")
	public List<Student> getStudent(){
		
		
		
		return repo.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteByID(@PathVariable int id) {
		
		repo.deleteById(id);
		return "successfuly delete student....";
	}
	
	@PutMapping("/update/{id}")
	public Student update(@PathVariable int id, @RequestBody Student std) {
		Optional<Student> optional=repo.findById(id);
		Student student= optional.get();		
		 student.setId(std.getId());
		 student.setName(std.getName());
		 student.setAge(std.getId());
		 student.setCity(std.getCity());
		
		return repo.save(student);
	}
}
