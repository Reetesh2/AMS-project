package com.mycompany.app.service;

import java.util.Collection;
import java.util.List;

import com.mycompany.app.model.AssignedGoal;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Manager;

public interface ManagerService {
	
	
	public Manager getManager(Long id);
	public Manager getManager(String email);
	public List<Employee> getAllEmployees();
	public Collection<Manager> getAllManagers();
	public Employee getEmployee(Long id);
	public List<Employee> searchEmployees(String keyword);
	public Employee getEmployee2(String username);
	List<AssignedGoal> getAllAssignedGoal(Employee employee);
     
}
