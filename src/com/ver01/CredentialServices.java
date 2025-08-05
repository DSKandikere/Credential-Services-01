package com.ver01;

import java.security.SecureRandom;

public class CredentialServices {
	private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL = "!@#$&_";
	private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;
	private static final SecureRandom rnd = new SecureRandom();
	    
	// Generate a random password which will contain (number, capital letter, small letter & special character)
	String generatePassword(int length) {
		if (length < 4) {
           throw new IllegalArgumentException("Length must be ≥ 4");
       }

       String pwd = "";
       pwd += UPPER.charAt(rnd.nextInt(UPPER.length()));
       pwd += LOWER.charAt(rnd.nextInt(LOWER.length()));
       pwd += DIGITS.charAt(rnd.nextInt(DIGITS.length()));
       pwd += SPECIAL.charAt(rnd.nextInt(SPECIAL.length()));

       // Step 2: fill remaining slots
       for (int i = pwd.length(); i < length; i++) {
           pwd += ALL.charAt(rnd.nextInt(ALL.length()));
       }

       // Step 3: shuffle characters using simple swap based on SecureRandom
       char[] arr = pwd.toCharArray();
       for (int i = 0; i < arr.length; i++) {
           int swapIdx = rnd.nextInt(arr.length);
           char tmp = arr[i];
           arr[i] = arr[swapIdx];
           arr[swapIdx] = tmp;
       }

       return new String(arr);
	}
	
	// Generate an email with the following syntax firstNamelastName@department.skit.ac.in
	public String generateEmailAddress(String firstName, String lastName, String department) {
       return firstName.toLowerCase() + lastName.toLowerCase() + "@" + department.toLowerCase() + ".skit.ac.in";
    }
	
	// Display the generated credentials
	 public void showCredentials(Employee employee, String email, String password) {
		 System.out.println("================EMPLOYEE CREDENTIALS================");
	     System.out.println("NAME          : " + employee.firstName + " " + employee.lastName);
	     System.out.println("Email ID      : " + email);
	     System.out.println("PASSWORD      : " + password);
	     System.out.println("====================================================");
	 }
}
