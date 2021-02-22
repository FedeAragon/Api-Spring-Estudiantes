package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	
	private final StudentService studenService;
	
	@Autowired
	public StudentController(StudentService studenService) {
		this.studenService = studenService;
	}

	@GetMapping
	public List<Student> getStudents() {
		return studenService.getStudents();
	}

	@PostMapping
	public void registerNewStudent(@RequestBody Student student){
		studenService.addNewStudent(student);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId){
		studenService.deleteStudent(studentId);
	}

	@PutMapping(path = "{studentId}")
	public void updateStudent(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email){
		studenService.updateStudent(studentId,name,email);
	}
}
