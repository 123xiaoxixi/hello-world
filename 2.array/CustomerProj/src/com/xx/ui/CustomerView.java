package com.xx.ui;

import com.xx.bean.Customer;
import com.xx.service.CustomerList;
import com.xx.util.CMUtility;

public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	
	public CustomerView() {
		Customer customer = new Customer("小李",'男',20,"123456789","123@qq.com");
		customerList.addCustomer(customer);
	}
	public void enterMainMenu() {
		boolean isFlag = true;
		while(isFlag) {
			System.out.println("\n----------------------------");
			System.out.println("                    1 添加客户");
			System.out.println("                    2 修改客户");
			System.out.println("                    3 删除客户");
			System.out.println("                    4 客户列表");
			System.out.println("                    5 退出\n");
			System.out.println("                 请选择(1-5): ");
			char menu = CMUtility.readMenuSelection();
			switch(menu) {
			case '1':
				addCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.print("确认是否退出(Y/N):");
				char c = CMUtility.readConfirmSelection();
				if(c == 'Y')
					isFlag = false;
				break;
			}
		}
	}
	private void addCustomer() {
//		System.out.println("添加");
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(13);
		System.out.print("邮箱：");
		String email = CMUtility.readString(15);
		Customer customer = new Customer(name,gender,age,phone,email);
		customerList.addCustomer(customer);
	}
	private void modifyCustomer() {
//		System.out.println("修改");
		System.out.println("---------------------修改客户-----------------------");
		for(;;) {
			System.out.print("请输入客户编号(-1退出):");
			int number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			else {
				Customer customer = customerList.getCustomer(number-1);
				if(customer == null) {
					System.out.print("客户不存在，请重新输入:");
					continue;
				}
				else {
					String name = customer.getName();
					char gender = customer.getGender();
					int age = customer.getAge();
					String phone = customer.getPhone();
					String email = customer.getEmail();
					
					System.out.print("姓名("+name+"):");
					String readname = CMUtility.readString(10, name);
					customer.setName(readname);
					System.out.print("性别("+gender+"):");
					customer.setGender(CMUtility.readChar(gender));
					System.out.print("年龄("+age+")：");
					customer.setAge(CMUtility.readInt(age));
					System.out.print("电话("+phone+"):");
					customer.setPhone(CMUtility.readString(11, phone));
					System.out.print("邮箱("+email+"):");
					customer.setEmail(CMUtility.readString(15, email));
//					customerList.addCustomer(customer);
					return;
				}
			}
		}
	}
	private void deleteCustomer() {
//		System.out.println("删除");
		int number;
		Customer cust;
		System.out.println("----------------------删除客户-----------------------");
		for(;;) {
			System.out.print("请输入要删除客户的编号(-1退出):");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			else {
				cust = customerList.getCustomer(number-1);
				if(cust == null) {
					System.out.print("客户不存在,请重新输入:");
					
				}else {
					System.out.print("确认要删除?(Y/N):");
					char readConfirmSelection = CMUtility.readConfirmSelection();
					if(readConfirmSelection == 'Y')
						break;
					else
						continue;
				}
			}
		}
		customerList.deleteCustomer(number-1);
	}
	private void listAllCustomers() {
//		System.out.println("列表");
		System.out.println("--------------------客户列表----------------------");
		int total = customerList.getTotal();
		if(total == 0) {
			System.out.println("没有客户记录!");
		}
		else {
			Customer[] custs = customerList.getAllCustomers();
			for(int i=0;i<custs.length;i++) {
				System.out.println((i+1)+"\t"+custs[i].getName()+"\t"+custs[i].getGender()
									+"\t"+custs[i].getAge()+"\t"+custs[i].getPhone()
									+"\t"+custs[i].getEmail());
			}
		}
		System.out.println("------------------------------------------------");

	}
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
}
