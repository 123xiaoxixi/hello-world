package com.xx.team.view.test;

import com.xx.team.domain.Employee;
import com.xx.team.service.NameListService;
import com.xx.team.service.TeamException;

public class ProgTest {
	public static void main(String[] args) {
		NameListService namelistservice = new NameListService();
		Employee[] employee = namelistservice.getAllEmployees();
		for(int i=0;i<employee.length;i++) {
			System.out.println(employee[i]);
		}
		System.out.println("****************");
		Employee employee1;
		try {
			employee1 = namelistservice.getEmployee(0);
			System.out.println(employee1);
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
}
