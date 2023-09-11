package com.amdocs.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.amdocs.POJO.*;

public class PetDAO {
	Statement stmt;
	ResultSet rs;
public int addNewPetDetails(Pet p1)

{
	int count=0;

	try {

	new MakeConnection();
	PreparedStatement pst=MakeConnection.getConnection()

	.prepareStatement("insert into Pet values(?,?,?,?,?,?,?,?)");

	pst.setInt(1, p1.petId);
	pst.setString(2, p1.petCategory);
	pst.setString(3, p1.petType);
	pst.setString(4, p1.color);
	pst.setInt(5, p1.age);
	pst.setDouble(6, p1.price);
	pst.setBoolean(7, p1.isVaccinated);
	pst.setString(8, p1.foodHabits);
	count= pst.executeUpdate();
	}catch(Exception e) {
	System.out.println("Error while inserting into database ");
	}
	return count;
	}



public int deletePetDetails(int id)
{
	int count=0;

	try {

	new MakeConnection();
	PreparedStatement pst=MakeConnection.getConnection()

	.prepareStatement("delete from Pet where petId="+id);

	count= pst.executeUpdate();


	}catch(Exception e) {

	System.out.println(e);

	}

	return count;

	
}


public int updatePetPriceAndVaccinationStatus(int petId,double price,int isVaccinated)
{
	int count=0;
	try {

		new MakeConnection();
		PreparedStatement pst=MakeConnection.getConnection()

		.prepareStatement("update Pet set price="+price+",isVaccinated="+isVaccinated+
				" where petId="+petId);

		count= pst.executeUpdate();
		}catch(Exception e) {
		System.out.println(e);
		}
	
	
	return count;
	
}


public ArrayList<Pet> showAllPets()
{
	ArrayList<Pet> petList=new ArrayList<Pet>();
	
	try {

	new MakeConnection();
	PreparedStatement pst=MakeConnection.getConnection()

	.prepareStatement("select * from Pet");

	ResultSet rs= pst.executeQuery();
	
	while(rs.next())
	{
		Pet p=new Pet(rs.getInt(1),rs.getString(2),rs.getString(3),
				rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getBoolean(7),rs.getString(8));
		petList.add(p);
		
	}
	

	}catch(Exception e) {

	System.out.println(e);

	}return petList;

}




public int countPetsByCategory(String category)
{
	int count=0;
	
	try {

		new MakeConnection();
		PreparedStatement pst=MakeConnection.getConnection()

		.prepareStatement("select count(petId) from Pet where petCategory='"+category+"'");

		rs= pst.executeQuery();
		rs.next();
		
			count= rs.getInt(1);
			
		

		}catch(Exception e) {

		System.out.println(e);

		}

		return count;

}



public ArrayList<Pet> searchByPrice(double min,double max)
{
	ArrayList<Pet> petList=new ArrayList<Pet>();
	
	try {

	new MakeConnection();
	PreparedStatement pst=MakeConnection.getConnection()

	.prepareStatement("select * from Pet where price>"+min+"AND price<"+max);

	ResultSet rs= pst.executeQuery();
	
	while(rs.next())
	{
		Pet p=new Pet(rs.getInt(1),rs.getString(2),rs.getString(3),
				rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getBoolean(7),rs.getString(8));
		petList.add(p);
		
	}
	

	}catch(Exception e) {

	System.out.println(e);

	}return petList;

}

public int countByVaccinationStatusForPetType(String petType)
{
	int count=0;
	try {

		new MakeConnection();
		PreparedStatement pst=MakeConnection.getConnection()

		.prepareStatement("select count(petId) from Pet where petType='"+petType+"' and isVaccinated=1");
		

		rs= pst.executeQuery();
		rs.next();
		
			count= rs.getInt(1);
			
		

		}catch(Exception e) {

		System.out.println(e);

		}

		return count;

}


}

