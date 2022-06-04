package com.xx.team.domain;

import com.xx.team.service.Status;

public class Programmer extends Employee{
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	public Programmer() {
		super();
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t程序員\t" + status + "\t\t\t" + equipment.getDescription();
	}
	public String getTeamBaseDetails() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}
	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t" + "程序員";
	}
}
