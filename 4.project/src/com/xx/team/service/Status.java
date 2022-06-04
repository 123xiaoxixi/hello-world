package com.xx.team.service;

public class Status {
	private final String NAME;
	
	private Status(String name) {
		this.NAME = name;
	}
	
	public String getNAME() {
		return NAME;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VACATION");
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return NAME;
	}
}
