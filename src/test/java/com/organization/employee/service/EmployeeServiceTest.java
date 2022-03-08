package com.organization.employee.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.organization.employee.entity.Employee;
import com.organization.employee.entity.EmployeeVO;
import com.organization.employee.repository.EmployeeRepo;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	EmployeeService employeeService;
	
		
	@Autowired
	EmployeeRepo employeeRepo;
	

	@Test
	void testGetHighestPaidEmployee() {
		
//		Employee emp = new Employee(112L,"Karan","Singh","Java",200000L,new Date(2022-10-23));
//		Employee emp1 = new Employee(113L,"Shuri","Shan","HR",100000L,new Date(2022-11-24));
//		Employee emp3 = new Employee(114L,"Nicole","Young","Java",50000L,new Date(2021-10-23));
//		Employee emp4 = new Employee(115L,"Young","Nicole","HR",400000L,new Date(2021-11-24));
//		
//		List<Employee> empList = new ArrayList<Employee>();
//		empList.add(emp);
//		empList.add(emp1);
//		empList.add(emp3);
//		empList.add(emp4);
//		
//		employeeRepo.saveAll(empList);
			
		List<EmployeeVO> emps = employeeService.getHighestPaidEmployee();
		
		List<Employee> employees = employeeRepo.highestSalary();

//		when(employeeRepo.highestSalary()).thenReturn(empList);
		
		assertEquals(employees.size(), emps.size());
		
		
		
	}
	
	
	@Disabled
	@Test
	void testSumOfDepartmentSalary() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testFilterByDepartmentAndDoj() {
		fail("Not yet implemented");
	}

}
