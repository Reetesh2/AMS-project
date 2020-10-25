package com.mycompany.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.GoalRating;
import com.mycompany.app.model.Manager;
import com.mycompany.app.service.ManagerServiceImpl;

@Controller
public class ManagerController {
	@Autowired
	ManagerServiceImpl managerService;

	
	@GetMapping("/manager")
	public ModelAndView showManager() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manager");
		List <Employee> listEmployee = managerService.getAllEmployees();
		mv.addObject("listEmployee", listEmployee);
		return mv;
	}
	
	@GetMapping("/manager/manager_profile")
	public ModelAndView showProfile(Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("managerProfile");
		String email=authentication.getName();
		Manager manager= managerService.getManager(email);
		mv.addObject("manager", manager);
		
		return mv;
	}
	
	@RequestMapping("/manager/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Employee> result = managerService.searchEmployees(keyword);
		ModelAndView mav = new ModelAndView("managerSearch");
		mav.addObject("result", result);
		return mav;		
	}	

	@RequestMapping("/manager/viewprofile")
	public ModelAndView profile(@RequestParam long id)
	{
		ModelAndView mav= new ModelAndView();
		mav.setViewName("managerEmployeeProfile");
		mav.addObject("employee", managerService.getEmployee(id));
		return mav;
	}
	
	@RequestMapping("/manager/viewgoals")
	public ModelAndView goals(Authentication authentication)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("managerEmployeeGoal");
		String username=authentication.getName();
		
		Employee employee=managerService.getEmployee2(username);
		
		List<AssignedGoal> assignedGoal=managerService.getAllAssignedGoal(employee);
		GoalRating gr=new GoalRating();
		mav.addObject("a", assignedGoal);
		mav.addObject("gr", gr);
		return mav;
	}

	@RequestMapping(value = "/manager/save/{id}", method = RequestMethod.POST)
	public ModelAndView savegoalRating(@ModelAttribute("goalrating") GoalRating goalrating,Authentication authentication,@PathVariable long id) {
		managerService.save(goalrating,id);
		ModelAndView mav=new ModelAndView("managerEmployeeGoal");
//		ag.setGoalRatingId(goalrating);
		mav.addObject("g", goalrating);
		mav.setViewName("ManagerViewGoalRating");
		
		
		return mav;

	}
	

}
