package ru.netology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.netology.models.Student;
import ru.netology.services.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/getAll")
	public String getAll(Model model) {
		List<Student> students = studentService.getAll();
		model.addAttribute("students", students);
		
		String username = "Admin";
		model.addAttribute("username", username);
		
		return "students";
	}
	
	@GetMapping("/getOne")
	@ResponseBody
	public Optional<Student> getOne(Integer Id) {
		return studentService.getOne(Id);
	}
	
	@PostMapping("/addNew")
	public String addNew(Student student) {
		studentService.addNew(student);
		return "redirect:/students/getAll";
	}

	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Student student) {
		studentService.update(student);
		return "redirect:/students/getAll";		
	}

	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer Id) {
		studentService.delete(Id);
		return "redirect:/students/getAll";		
	}
}