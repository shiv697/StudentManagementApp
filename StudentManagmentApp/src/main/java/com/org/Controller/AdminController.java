package com.org.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.model.Student;
import com.org.service.StudentService;

@Controller
public class AdminController {
	@Autowired
	StudentService ss;

	@RequestMapping
	public String preLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String onlogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model m) {
		if (username.equals("shivani") && password.equals("shiv@123")) {
			List<Student> list = ss.getAllStudents();
			m.addAttribute("data", list);

			return "adminscreen";
		} else {
			m.addAttribute("login_fail", "invalid careditaional");

			return "login";

		}
	}

	@RequestMapping("/enroll_Student")
	public String saveStudent(@ModelAttribute Student s, Model m) {
		ss.saveStudentDetails(s);
		List<Student> list = ss.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	@RequestMapping("/search")
	public String searchBatch(@RequestParam("batchNumber")String batchNumber,Model m)
	{
		List<Student>result=ss.searchBatch(batchNumber);
		if(result.size()>0)
		{
			m.addAttribute("data",result);
			}else
			{
				m.addAttribute("message","No Record are found for this "+batchNumber);
			}
		return "adminscreen";
	}
	@RequestMapping("/fees")
	public String onFees(@RequestParam("id") int id,Model m)
	{
		Student s=ss.getSingleStudent(id);
		m.addAttribute("st", s);
		return"fees";
	}
	@RequestMapping("/payfees")
	public String payfees(@RequestParam("studentid") int studentid,@RequestParam("ammount") float ammount ,Model m)
	{
		List<Student> list=ss.updateStudentfees(studentid,ammount);
		m.addAttribute("data",list);
		return"adminscreen";
	}
	@RequestMapping("/remove")
	public String removeStudent(@RequestParam("id") int id,Model m)
	{
		ss.removeDelete(id);
		List<Student>list=ss.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
		
	}
}


   
       
    