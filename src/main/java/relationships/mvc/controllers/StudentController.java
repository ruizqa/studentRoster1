package relationships.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import relationships.mvc.models.Student;
import relationships.mvc.services.StudentService;



@Controller
public class StudentController {
	private final StudentService serv;
	 
	 public StudentController(StudentService serv) {
	     this.serv = serv;
	     }

	
	 @RequestMapping("/students")
	 public String index(Model model) {
		 List <Student> students = serv.allStudents();
		 model.addAttribute("students",students);
		 System.out.println(students);
	     return "/students/index.jsp";

	 }
	 
	 
	 @RequestMapping("/students/new")
	 public String index() {
	     return "/students/new.jsp";

	 }
	 
	 @RequestMapping(value="/students/create")
	 public String create(@RequestParam(value="firstName") String firstName,
			 @RequestParam(value="lastName") String lastName,
			 @RequestParam(value="age") int age) {
	     
		 Student s = new Student (firstName, lastName, age);
		 serv.createStudent(s);
		 return "redirect:/students";
		 
		  
	 }
	 
	 
	 @RequestMapping(value="/students/{id}")
	 public String display(@PathVariable("id") Long id, Model model) {
	     Student student = new Student();
	     student = serv.findStudent(id);
		 model.addAttribute("student", student);
		 return "/students/show.jsp";
	 }
	 
	 
	 

	 
}
