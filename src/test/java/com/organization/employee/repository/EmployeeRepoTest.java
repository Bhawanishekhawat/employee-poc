package com.organization.employee.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import com.organization.employee.entity.Employee;
import com.organization.employee.entity.IDepartment;



@DataJpaTest
class EmployeeRepoTest {

	@Autowired
	private EmployeeRepo empRepo;

	@AfterEach
	void tearDown() {
		empRepo.deleteAll();
	}
	

	@Test
	void testHighestSalaryFromEachDepartmentIfDepartmentExist() {
		
		Employee emp1 = new Employee("Rahul","Sharma","HR",50000L,new Date(2008-07-27));
		Employee emp2 = new Employee("Ram","Aarya","HR",60000L,new Date(2008-07-27));
		Employee emp3 = new Employee("Rahul","Sharma","Admin",40000L,new Date(2008-07-27));
		Employee emp4 = new Employee("Ram","Aarya","Admin",70000L,new Date(2008-07-27));
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		empRepo.saveAll(list);	
		
		List<Employee> emps = empRepo.highestSalary();
		Employee actual = emps.get(0);
		Employee actual1 = emps.get(1);
		
		assertThat(60000L).isEqualTo(actual.getSalary());
		assertThat(70000L).isEqualTo(actual1.getSalary());
	}
	
	@Test
	void testHighestSalaryFromEachDepartmentWithResultListSize() {
		
		Employee emp1 = new Employee("Rahul","Sharma","HR",50000L,new Date(2008-07-27));
		Employee emp2 = new Employee("Ram","Aarya","HR",60000L,new Date(2008-07-27));
		Employee emp3 = new Employee("Rahul","Sharma","Admin",40000L,new Date(2008-07-27));
		Employee emp4 = new Employee("Ram","Aarya","Admin",70000L,new Date(2008-07-27));
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		empRepo.saveAll(list);	
		
		List<Employee> emps = empRepo.highestSalary();
				
		assertThat((emps).size()).isNotEqualTo(3);
		
	}
	
	@Test
	void testSumOfDepartmentSalaryFromEachDepartment() {
		
		Employee emp1 = new Employee("Rahul","Sharma","HR",50000L,new Date(2008-07-27));
		Employee emp2 = new Employee("Ram","Aarya","HR",60000L,new Date(2008-07-27));
		Employee emp3 = new Employee("Rahul","Sharma","Admin",80000L,new Date(2008-07-27));
		Employee emp4 = new Employee("Ram","Aarya","Admin",70000L,new Date(2008-07-27));
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		empRepo.saveAll(list);	
		
		List<IDepartment> sumOfSalary = empRepo.sumOfdepartmentSalary();
		IDepartment idepart1 = sumOfSalary.get(0);
		IDepartment idepart2 = sumOfSalary.get(1);
		
		assertThat(150000L).isEqualTo(idepart1.getSumOfSalary());
		assertThat(110000L).isEqualTo(idepart2.getSumOfSalary());
	}
	
	@Test
	void testSumOfDepartmentSalaryFromEachDepartmentWithResultListSize() {
		
		Employee emp1 = new Employee("Rahul","Sharma","HR",50000L,new Date(2008-07-27));
		Employee emp2 = new Employee("Ram","Aarya","HR",60000L,new Date(2008-07-27));
		Employee emp3 = new Employee("Rahul","Sharma","Admin",80000L,new Date(2008-07-27));
		Employee emp4 = new Employee("Ram","Aarya","Admin",70000L,new Date(2008-07-27));
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		empRepo.saveAll(list);	
		
		List<IDepartment> sumOfSalary = empRepo.sumOfdepartmentSalary();
		
		
		assertThat((sumOfSalary)).size().isNotEqualTo(3);
		
	}
	
	@Test
	void FilterDataBasedOnDepartmentAndDojIfExist() {
		//given
		
		Employee emp = new Employee("Rahul","Sharma","HR",50000L,new Date(2008-07-27));
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp);
		empRepo.saveAll(list);		
	
	
	//when
	List<Employee> actual = empRepo.filterData("HR",new Date(2008-07-27));
	
	//then
	assertThat(actual).isEqualTo(list);
	 
	}

	@Test
	void FilterDataBasedOnDepartmentAndDojIfNotExist() {
		//given
		
		Employee emp = new Employee("Rahul","Sharma","HR",50000L,new Date(2008-07-27));
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp);
		empRepo.saveAll(list);		
	
	
	//when
	List<Employee> actual = empRepo.filterData("Java",new Date(2008-07-27));
	
	//then
	assertThat(actual).isNotEqualTo(list);
	 
	}
	
//	@Test
//	void testHighestSalary() {
//		List<Employee> emp = empRepo.highestSalary();
//		Employee employee = emp.get(0);
//		
//		assertThat(184896L).isEqualTo(employee.getSalary());
//	}
//	
//	@Test
//	void testDepartmentSalary() {
//
//		// when
//		List<IDepartment> sumOfSalary = empRepo.departmentSalary();
//
//		IDepartment idepart = sumOfSalary.get(0);
//		assertThat(3105332L).isEqualTo(idepart.getSumOfSalary());
//	}
//
//	@Test
//	void testFilterData() {
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		Date date = new Date(0000, 00, 00);
//		try {
//			date = formatter.parse("1983-01-28 00:00:00.000000");
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}
//		//when
//		List<Employee> employees = empRepo.filterData("Java", date);
//		
//		Employee employee = employees.get(0);
//		
//		//then
//		
//		assertThat("Carol").isEqualTo(employee.getFirst_name());
//		
//	}	
}
