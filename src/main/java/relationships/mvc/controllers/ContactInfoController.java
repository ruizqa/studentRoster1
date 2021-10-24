package relationships.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import relationships.mvc.models.ContactInfo;
import relationships.mvc.models.Student;
import relationships.mvc.repositories.StudentRepository;
import relationships.mvc.services.ContactInfoService;
import relationships.mvc.services.StudentService;

@Controller
public class ContactInfoController {
	private final ContactInfoService serv;
	private final StudentService studServ;

	
	
	 public ContactInfoController(ContactInfoService serv, StudentService studServ) {
	     this.serv = serv;
	     this.studServ = studServ;
	 }
	 
	 @RequestMapping("/contact/new")
	 public String index(Model model) {
		 List<Student> students = studServ.allStudents();
		 model.addAttribute("students",students);
	     return "/contact/new.jsp";
	 }
	 
	 @RequestMapping(value="/contact/create")
	 public String create(@RequestParam(value="studentID") Long studentID,
			 @RequestParam(value="address") String address,
			 @RequestParam(value="city") String city,
			 @RequestParam(value="state") String state) {
	     
		 Student s = studServ.findStudent(studentID);
		 ContactInfo CI = new ContactInfo(address, city, state, s);
		 serv.createContactInfo(CI);
		 return "redirect:/students";
		 
	 }
}
