package com.ver01;

import java.util.Scanner;

public class Employee {
		String firstName;
		String lastName;
		
		public Employee(){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("FIRST NAME: ");
			this.firstName = sc.next();
			
			System.out.println("LAST NAME: ");
			this.lastName = sc.next();
		}
}
