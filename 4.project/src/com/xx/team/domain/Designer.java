package com.xx.team.domain;

public class Designer extends Programmer{
	private double bonus;

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public Designer() {
		super();
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "\t設計師\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t設計師\t" + getBonus();
	}
}
