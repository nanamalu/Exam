package jp.ac.ohara.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.ac.ohara.score.modls.StudentModel;
import jp.ac.ohara.score.service.StudentService;


@Controller
public class MainController {
	
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/")
	public String base() {
		return"base";
	}
	
	@GetMapping("/student/")
	public ModelAndView create(StudentModel studentmodel,ModelAndView model) {
		model.addObject("data",studentmodel);
		model.setViewName("create");
		return model;
	}
		
	@PostMapping("/student/")
	 public String create(StudentModel studentmodel,Model model,RedirectAttributes redirectattributes) {
		try {
			this.studentservice.saveStudent(studentmodel);
			redirectattributes.addFlashAttribute("exception","");
		}catch(Exception e) {
			redirectattributes.addFlashAttribute("exception",e.getMessage());
		}
		return "redirect:/";
		}	
		@GetMapping("/index")
		 public String show(Model model,StudentModel studentmodel) {
			this.studentservice.getAllStudents();
			model.addAttribute("studentlist",studentservice.getAllStudents());
			return"indeX";
			
		}
   }
