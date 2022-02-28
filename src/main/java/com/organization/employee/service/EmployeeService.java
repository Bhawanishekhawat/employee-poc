package com.organization.employee.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.organization.employee.entity.DepartmentVO;
import com.organization.employee.entity.Employee;
import com.organization.employee.entity.EmployeeVO;
import com.organization.employee.entity.IDepartment;
import com.organization.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	
	public List<EmployeeVO> getHighestPaidEmployee(){
		List<Employee> employees = employeeRepo.highestSalary();
		List<EmployeeVO> emp =  new ArrayList<EmployeeVO>();
		for(Employee employee:employees) {
			EmployeeVO empVO = new EmployeeVO(employee.getFirst_name(), employee.getLast_name(), employee.getDepartment(), employee.getSalary());
		emp.add(empVO);
		}
		return emp;
			}
	
	public List<IDepartment> sumOfDepartmentSalary(){
		return employeeRepo.departmentSalary();
		
		}
	public List<Employee> filterByDepartmentAndDoj(String department, String str_date){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date(0000, 00, 00);
		try {
			date = formatter.parse(str_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeRepo.filterData(department, date);
	}
}
