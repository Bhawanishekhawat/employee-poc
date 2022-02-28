package com.organization.employee.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.organization.employee.entity.Employee;
import com.organization.employee.entity.IDepartment;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	
	@Query (value = "SELECT * FROM employeedb.Employee_data WHERE salary IN (SELECT max(salary) AS salary From employeedb.Employee_data GROUP BY department)" 
			, nativeQuery = true)
	public  List<Employee> highestSalary();
		
	
	
	@Query  (value = "SELECT department as department,sum(salary) as sumOfSalary FROM employeedb.employee_data group by department",nativeQuery = true)
	public List<IDepartment>  departmentSalary();
	
	@Query(value = "SELECT * FROM employeedb.employee_data where department = ?1 and date_of_joining = ?2", nativeQuery = true)
	public List<Employee> filterData(String department, Date date);
	
	
}
