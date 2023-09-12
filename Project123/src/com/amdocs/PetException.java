package com.amdocs;

public class PetException extends Exception {
	
	PetException() {
	     System.out.println("Pet not available");
	   }
	PetException(int a)
	{
		System.out.print("Please enter a positive integer");
	}

}
