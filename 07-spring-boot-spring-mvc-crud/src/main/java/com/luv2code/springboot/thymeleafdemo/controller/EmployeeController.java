package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


 private EmployeeService employeeService;

 public EmployeeController(EmployeeService theEmployeeService){
	 employeeService = theEmployeeService;
 }
	// add mapping for "/list"



	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// get the employee from db
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public  String showFormForAdd(Model theModel){

	 // create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee", theEmployee);

	return "employees/employee-form";
	}

	@GetMapping("showFormForUpdate")
	public String ShowFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

	    // get theemployee from the service
		Employee theEmployee = employeeService.findById(theId);

		// set employee in the model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);

		//send over to our form
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee theEmployee){

	 //save the employee
		employeeService.save(theEmployee);

		// use a redirect to prevent dupe submissions

		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId){

		// delete employee by id
		employeeService.deleteById(theId);

		// redirect to employee/list
		return "redirect:/employees/list";
	}

}









