package com.mycompany.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.GoalRating;
import com.mycompany.app.model.Manager;
import com.mycompany.app.repository.AssignedGoalRepository;
import com.mycompany.app.repository.EmployeeRepository;
import com.mycompany.app.repository.GoalRatingRepository;
import com.mycompany.app.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired 
	ManagerRepository managerRepository;
    
	@Autowired
	AssignedGoalRepository assignedGoalRepository;
	
	@Autowired
	GoalRatingRepository GoalRatingRepository;

	@Override
	public Manager getManager(Long id) {
		Optional<Manager> manager = managerRepository.findById(id);
		if(manager.isPresent()) {
			return manager.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Collection<Manager> getAllManagers() {
		return managerRepository.findAll();
	}

	@Override
	public Manager getManager(String email) {
		Optional<Manager> manager = managerRepository.findByEmail(email);
		if(manager.isPresent()) {
			return manager.get();
		}
		return null;
	}

	@Override
	public List<Employee> searchEmployees(String keyword) {
		return employeeRepository.searchEmployee(keyword);
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Employee getEmployee2(String username)
	{
		 List<Manager> managers=managerRepository.searchManager(username);
		Manager man= managers.get(0);
		 Long id=man.getId();
		 String k=""+id;
		List<Employee> employees=employeeRepository.searchEmployee(k);
		Employee employee=employees.get(0);
		return employee;
	}
	
	@Override
	public List<AssignedGoal> getAllAssignedGoal(Employee employee)
	{
		return assignedGoalRepository.findByEmployee(employee);
	}
	
	public AssignedGoal save(GoalRating goalRating,long id) {
		
		
		GoalRatingRepository.save(goalRating);
		AssignedGoal ag=assignedGoalRepository.getOne(id);
		ag.setGoalRatingId(goalRating);
		assignedGoalRepository.save(ag);
		return ag;

	
	}

}
