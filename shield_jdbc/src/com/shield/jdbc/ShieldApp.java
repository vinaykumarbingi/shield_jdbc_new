package com.shield.jdbc;

import java.util.Scanner;

import com.options.Option;

public class ShieldApp {

	public static void main(String[] args) 
	{
		System.out.println("=======------S.H.I.E.L.D ------========= \r\n\n" + 
				"Welcome to Captain Fury. \r\n\n" + 
				"1. Check the missions \r\n" + 
				"2. Assign mission to Avengers \r\n" + 
				"3. Check mission’s details \r\n" + 
				"4. Check Avenger’s details \r\n" + 
				"5. Update Mission’s status \r\n" + 
				"6. List Avengers \r\n"+
				"7. Add Avengers \r\n"+
				"8. Exit \r\n\n");
		String userInput;
		int choice=-1;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Enter the option:");
			userInput=sc.nextLine();
			try {
				choice=Integer.parseInt(userInput);
			}catch(NumberFormatException ex)
			{
				System.out.println("Please enter choice in digit only!!!");
				continue;
			}
			if(choice<1 || choice >8)
			{
				System.out.println("Please enter valid choice in digit !!!");
				continue;
			}
			switch (choice) {
			case 1:
				
				Option.checkTheMissions();
				break;
			case 2:
				System.out.println("Enter Avengers:");
				String avengerNames=sc.nextLine();
				System.out.println("Enter Mission Name:");
				String missionName=sc.nextLine();
				System.out.println("Enter Mission Details:");
				String missionDetails=sc.nextLine();
				
				Option.assignMissionToAvenger(avengerNames, missionName, missionDetails);
				
				break;
			case 3:
				System.out.println("Enter Mission Name: ");
				String checkMissionName=sc.nextLine();
				
				Option.checkMissionDetails(checkMissionName);
				break;
			case 4:
				System.out.println("Enter Avenger Name: ");
				String checkAvengerName=sc.nextLine();
				
				Option.checkAvengerDetails(checkAvengerName);
				break;
			case 5:
				System.out.println("Enter Mission Name: ");
				String updateMissionName=sc.nextLine();
				System.out.println("Enter New Status: ");
				String status=sc.nextLine();
				
				Option.updateMissionstatus(updateMissionName, status);
				
				break;
			case 6:
				Option.listAvengers();
				break;
			case 7:
				System.out.println("Enter Avenger name: ");
				String avengerName=sc.nextLine();
				System.out.println("Enter personal name: ");
				String personName=sc.nextLine();
				System.out.println("Enter abilities: ");
				String abilities=sc.nextLine();
				Option.addAvengers(avengerName, personName, abilities);
			default:
				break;
			}
		}while(choice!=8);
		sc.close();
	}

}
