package com.amdocs;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.amdocs.DAO.PetDAO;
import com.amdocs.POJO.Pet;

public class MainFile {
	
public static void main(String[] args) 
{
	while (true) 
	{//WHILE LOOP OPENS 
	
		try {
			
			System.out.println("\nMenu:");			
			System.out.println("1. Add new pet details");
			System.out.println("2. Update pet price and Vaccination Status");			
			System.out.println("3. Delete pet details");
			System.out.println("4. View all pets");
			System.out.println("5. Count pets by category");
			System.out.println("6. Search by price range");
			System.out.println("7. Count number of vaccinated pets for a given pet type");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");
			
			Scanner sc=new Scanner(System.in);			
			int choice = sc.nextInt();
			int count;int petId;String category;
			int age;double price;boolean isVaccinated;
			String petType;String color;String foodHabits;	
			
			PetDAO p2=new PetDAO();//creating a petDAO object to access its methods
			switch (choice) {
			
				case 1:
				System.out.print("Enter pet id");
				petId=sc.nextInt();
				System.out.print("Enter pet category");
				category=sc.next();
				sc.nextLine();
				System.out.print("Enter pet type");
				petType=sc.nextLine();
				System.out.print("Enter pet color");
				color=sc.next();
				sc.nextLine();
				System.out.print("Enter pet age");
				age=sc.nextInt();
				System.out.print("Enter price");
				price=sc.nextDouble();
				System.out.print("Is the pet vaccinated");
				isVaccinated=sc.nextBoolean();
				sc.nextLine();				
				System.out.print("Enter foodhabits");
				foodHabits=sc.nextLine();
				//creating a pet object with the input from user
				Pet p1=new Pet(petId,category,petType,color,age,price,isVaccinated,foodHabits);
				count=p2.addNewPetDetails(p1);//calling add new pet function from petDAO class
				if(count==0) System.out.print("petID already exists");
				else System.out.print(count+" rows affected");
				break;
			
			
			
			// updatePetDetails();
			
			case 2:
				sc.nextLine();
				System.out.println("Enter pet id ");
				petId=sc.nextInt();
				System.out.println("Enter new price and vaccination status");
				price= sc.nextDouble();
				isVaccinated=sc.nextBoolean();
				//since the datatype of isVaccinated in database is int
				int intIsVaccinated=(isVaccinated) ? 1 : 0;
				count=p2.updatePetPriceAndVaccinationStatus(petId,price,intIsVaccinated);
				if(count==0)//throw a userdefined exception when no pet is found or updated
					 try{throw new PetException();}catch(PetException e) {}
				else System.out.print(count+" rows affected ");				
				break;
				
			
			//delete pet details using petId	
			case 3:
			System.out.print("Enter pet id");
			petId=sc.nextInt();
			count=p2.deletePetDetails(petId);
			if(count==0)
				 try{throw new PetException();}catch(PetException e) {}
			else System.out.print(count+" rows affected");
			break;
			
			
			case 4://show all pets
			ArrayList<Pet> pet=p2.showAllPets();//return type should be list
			if(pet.isEmpty())  try{throw new PetException();}catch(PetException e) {}
			else{for (Pet i : pet)
				System.out.print(i);
			}
			break;
			
			
			case 5://count number of pets for a category
			System.out.println("Enter Category");
			category=sc.next();
			count=p2.countPetsByCategory(category);
			if(count==0)
			try{throw new PetException();}catch(PetException e) {}
			else
			System.out.print("Number of "+category+" = "+count);
			break;
			
			
			case 6://search by price range
			System.out.println("Enter price range");
			double min=sc.nextDouble();
			double max=sc.nextDouble();
			ArrayList<Pet> li=p2.searchByPrice(min,max);
			if(li.isEmpty())//if no pet price exist in that range then show pet not available
				try{throw new PetException();}catch(PetException e) {}
			else{for (Pet i : li)
				System.out.print(i);
			}
			break;
			
			case 7://count by vaccination status for pet type
			System.out.println("Enter pet type");
			sc.nextLine();
			petType=sc.nextLine();		
			count=p2.countByVaccinationStatusForPetType(petType);
			if(count==0) try{throw new PetException();}catch(PetException e) {}
			else System.out.println("Number of Vaccinated "+petType+" = "+count);	
			break;
			
			
			case 8:	
			System.out.println("Exiting the Pet Store System.");	
			sc.close();	
			System.exit(0);
			default:	
			System.out.println("Invalid choice. Please select a valid option.");
			
			}//switch block closes
		}//tryblock closes
			catch(InputMismatchException e) {//when data type of input is not correct 
			System.out.print("Enter correct values");}
			catch(Exception e) {
				System.out.print(e);	
			}
		
		}//while closes
}//main function closes
}//class MainFile closes

