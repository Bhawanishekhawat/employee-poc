package com.organization.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {
	
	
	private String first_name;
	private String last_name;
	private String department;
	private Long salary;

}
