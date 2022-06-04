package com.xx.team.view;

import com.xx.team.domain.Employee;
import com.xx.team.domain.Programmer;
import com.xx.team.service.NameListService;
import com.xx.team.service.TeamException;
import com.xx.team.service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		char menu='0';
		boolean loopFlag = true;
		while(loopFlag){
			if(menu != '1')
				listAllEmployees();
			System.out.print("1-團隊列表 2-添加團隊成員 3-刪除團隊成員 4-退出 請選擇(1-4):");
			menu = TSUtility.readMenuSelection();
			switch(menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("確認是否退出(Y/N):");
				if(TSUtility.readConfirmSelection() == 'Y') {
					loopFlag = false;
				}
				break;
			}
		}
	}
	private void listAllEmployees() {
		System.out.println("ID\t姓名\t年齡\t工資\t職位\t狀態\t獎金\t股票\t領用設備");
		Employee[] employee = listSvc.getAllEmployees();
		for(int i=0;i<employee.length;i++) {
			System.out.println(employee[i]);
		}
		System.out.println("---------------------------------------------------------------");
	}
	private void getTeam() {
		System.out.println("------------------------------團隊列表----------------------------");
		Programmer[] team = teamSvc.getTeam();
		if(team == null || team.length == 0) {
			System.out.println("開發團隊沒有成員");
		}
		else{
			System.out.println("TID/ID\t姓名\t年齡\t工資\t職位\t獎金\t股票\n");
			for(int i=0;i<team.length;i++) {
//				System.out.println(team[i]);
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		System.out.println("---------------------------------------------------------------");
	}
	private void addMember() {
		System.out.print("請輸入要添加成員的ID:");
		int readID = TSUtility.readInt();
		try {
			teamSvc.addMember(listSvc.getEmployee(readID));
			System.out.println("添加成功");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失敗，原因:"+e.getMessage());
		}
		TSUtility.readReturn();
	}
	private void deleteMember() {
		System.out.println("------------------------------刪除成員----------------------------");
		System.out.print("請輸入要刪除的成員TID：");
		int readInt = TSUtility.readInt();
		System.out.print("確認是否刪除(Y/N):");
		char readConfirmSelection = TSUtility.readConfirmSelection();
		if(readConfirmSelection == 'N')
			return;
		try {
			teamSvc.removeMember(readInt);
			System.out.println("刪除成功");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("刪除失敗,原因:"+e.getMessage());
		}
		TSUtility.readReturn();
	}
	public static void main(String[] args) {
		TeamView teamview = new TeamView();
		teamview.enterMainMenu(); 
	}
}
