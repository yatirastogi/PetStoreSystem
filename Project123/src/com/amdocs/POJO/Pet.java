package com.amdocs.POJO;


public class Pet {

public int petId;
public String petCategory;
public String petType;
public String color;
public int age;
public double price;
public boolean isVaccinated;
public String foodHabits;


public Pet(int petId, String petCategory, String petType, String color, int age, double price, boolean isVaccinated,
		String foodHabits) {
	super();
	this.petId = petId;
	this.petCategory = petCategory;
	this.petType = petType;
	this.color = color;
	this.age = age;
	this.price = price;
	this.isVaccinated = isVaccinated;
	this.foodHabits = foodHabits;
}

public String toString(){
	//overriding the toString() method  
	  return petId+" "+petCategory+" "+petType+" "+color+
			  " "+age+" "+ price+" "+isVaccinated+" "+foodHabits+"\n";  
	 }
}