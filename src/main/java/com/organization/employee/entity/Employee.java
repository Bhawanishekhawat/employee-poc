package com.organization.employee.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table (name = "employee_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@NotNull(message = "{firstName}")
	@Column(name = "firstName")
	private String first_name;
	@NotNull(message = "{lastName}")
	@Column(name = "lastName")
	private String last_name;
	@NotNull(message = "{department}")
	@Column(name = "department")
	private String department;
	@NotNull(message = "{salary}")
	@Range(min = 1)
	@Column(name = "salary")
	private Long salary;
	@NotNull(message = "{dateOfJoining}")
	@DateTimeFormat(pattern="yyyy/mm/dd")
	@Column(name = "date_Of_Joining")
	private Date date_Of_joining;
	
	
	public Employee(@NotNull(message = "{firstName}") String first_name,
			@NotNull(message = "{lastName}") String last_name, @NotNull(message = "{department}") String department,
			@NotNull(message = "{salary}") @Range(min = 1) Long salary,
			@NotNull(message = "{dateOfJoining}") Date date_Of_joining) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.department = department;
		this.salary = salary;
		this.date_Of_joining = date_Of_joining;
	}
	

}
