package com.ver01;

import java.util.Scanner;

public class ImplementCredentialServices {

	static void message() {
		
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
	}
	
	public static void main(String[] args) {

			int ch;
			Scanner sc = new Scanner(System.in);
			
			CredentialServices cs = new CredentialServices();
	        Employee emp = new Employee();
	        String department = "";

	        do {
	            System.out.println("\nPlease enter the department from the following: ");
	            message();
	            ch = sc.nextInt();

	            switch (ch) {
	                case 1:
	                    department = "technical";
	                    break;
	                case 2:
	                    department = "admin";
	                    break;
	                case 3:
	                    department = "hr";
	                    break;
	                case 4:
	                    department = "legal";
	                    break;
	                default:
	                    System.out.println("Invalid Choice...!!!");
	            }
	        } while (ch < 1 || ch > 4);

	        String email = cs.generateEmailAddress(emp.firstName, emp.lastName, department);
	        String password = cs.generatePassword(10);
	        cs.showCredentials(emp, email, password);

	}

}
