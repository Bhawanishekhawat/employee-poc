package com.organization.employee.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.employee.entity.DepartmentVO;
import com.organization.employee.entity.Employee;
import com.organization.employee.entity.EmployeeVO;
import com.organization.employee.entity.IDepartment;
import com.organization.employee.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/getEmployee")
	public List<EmployeeVO> findHighestPaidEmployee(){
		return employeeService.getHighestPaidEmployee();
	
	}
	
	@GetMapping("/getSalarySum")
	public List<IDepartment> findSumOfDepartmentSalary(){
		return employeeService.sumOfDepartmentSalary();
   }
	
	@GetMapping("/getEmployee/{department}/{date}")
	public List<Employee> filterByDeptAndDoj(@PathVariable String department, @PathVariable String date){
		return employeeService.filterByDepartmentAndDoj(department, date);
		
	}
}
