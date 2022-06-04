package com.xx.team.service;

import com.xx.team.domain.Architect;
import com.xx.team.domain.Designer;
import com.xx.team.domain.Employee;
import com.xx.team.domain.Equipment;
import com.xx.team.domain.NoteBook;
import com.xx.team.domain.PC;
import com.xx.team.domain.Printer;
import com.xx.team.domain.Programmer;

import static com.xx.team.service.Data.*;

public class NameListService {
	private Employee[] employees;

	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		
		
		
		for(int i=0;i<EMPLOYEES.length;i++) {
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			Equipment equipment;
			
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id,name,age,salary); 
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				employees[i] = new Designer(id, name, age, salary, equipment, Double.parseDouble(EMPLOYEES[i][5]));
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				employees[i] = new Architect(id, name, age, salary, equipment, Double.parseDouble(EMPLOYEES[i][5]), Integer.parseInt(EMPLOYEES[i][6]));
				break;
			}
		}
	}
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		switch (type) {
		case PC:
			return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		case NOTEBOOK:
			return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
		case PRINTER:
			return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		}
		return null;
	}
	public Employee[] getAllEmployees() {
		return employees;
	}
	public Employee getEmployee(int id) throws TeamException {
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId() == id){
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的員工");
	}
	
	
}
