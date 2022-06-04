package com.xx.team.service;

import com.xx.team.domain.Architect;
import com.xx.team.domain.Designer;
import com.xx.team.domain.Employee;
import com.xx.team.domain.Programmer;

public class TeamService {
	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total;
	public TeamService() {
		super();
	}
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i=0;i<team.length;i++)
			team[i] = this.team[i];
		return team;
	}
	public void addMember(Employee e) throws TeamException {
		if(total >= MAX_MEMBER) {
			throw new TeamException("成員已滿");
		}
		if (!(e instanceof Programmer)) {
			throw new TeamException("該成員不是開發成員，不能添加");
		}
		if(isExit(e)) {
			throw new TeamException("該成員已存在，不能添加");
		}
		if(((Programmer)e).getStatus().getNAME().equals("BUSY")) {
			throw new TeamException("該成員已在別的開發團隊，不能添加");
		}
		if("VOCATION".equals(((Programmer)e).getStatus().getNAME())){
			throw new TeamException("該成員已在休假，不能添加");
		}
		int numOfArch=0,numOfDesi=0,numOfProg=0;
		for(int i=0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDesi++;
			}
			else
				numOfProg++;  
		}
		if(e instanceof Architect) {
			if(numOfArch >= 1) {
				throw new TeamException("團隊至多一名架構師");
			}
		}else if(e instanceof Designer) {
			if(numOfDesi >= 2) {
				throw new TeamException("團隊至多兩名設計師");
			}
		}else {
			if(numOfProg >= 3) {
				throw new TeamException("團隊至多三名程序員");
			}
		}
		Programmer p = (Programmer) e;
		team[total++] = p;
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		
	}
	private boolean isExit(Employee e) {
		for(int i=0;i<total;i++){
			if(team[i].getId() == e.getId())
				return true;
		}
		return false;
	}
	public void removeMember(int memberId) throws TeamException {
		int i=0;
		for(i=0;i<total;i++) {
			if(memberId == team[i].getMemberId()) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if(i >= total) {
			throw new TeamException("要移除的ID沒找到，刪除失敗");
		}
		for(int j=i+1;j<total;j++) {
			team[j-1] = team[j];
		}
		team[--total] = null;
	}
}
