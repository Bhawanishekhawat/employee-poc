package com.organization.employee;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class EmployeeApplicationTests {
	
	Calculator calc = new Calculator();

	@Test
	void shouldAddTwoNumbers() {
		
		int numberOne= 10;
		int numberTwo = 20;
		
	int result= calc.add(numberOne, numberTwo);
		
	assertThat(result).isEqualTo(30);
		
	}
	
	class Calculator{
		
		int add (int a, int b) {
			return a+b;
		}
	}
}
