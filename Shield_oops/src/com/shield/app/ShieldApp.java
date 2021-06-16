package com.shield.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shield.avenger.Avenger;
import com.shield.mission.Mission;
import com.shield.utility.AvengerUtility;
import com.shield.utility.MissionUtility;

public class ShieldApp {
	
	public static List<Avenger> avengersInSquad=AvengerUtility.getAllAvengersInSquad();
	public static List<Mission> missionsInShield=new ArrayList<Mission>();
	
	public static void main(String[] args) {
		AvengerUtility avengerUtilityObj=new AvengerUtility();
		MissionUtility missionUtilityObj=new MissionUtility();
		System.out.println("=======------S.H.I.E.L.D ------========= \r\n\n" + 
				"Welcome to Captain Fury. \r\n\n" + 
				"1. Check the missions \r\n" + 
				"2. Assign mission to Avengers \r\n" + 
				"3. Check mission’s details \r\n" + 
				"4. Check Avenger’s details \r\n" + 
				"5. Update Mission’s status \r\n" + 
				"6. List Avengers \r\n"+
				"7. Exit \r\n\n");
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
			if(choice<1 || choice >7)
			{
				System.out.println("Please enter valid choice in digit !!!");
				continue;
			}
			switch (choice) {
			case 1:
				missionUtilityObj.listShieldMissions(missionsInShield);
				break;
			case 2:
				System.out.println("Enter Avengers:");
				String avengerNames=sc.nextLine();
				System.out.println("Enter Mission Name:");
				String missionName=sc.nextLine();
				System.out.println("Enter Mission Details:");
				String missionDetails=sc.nextLine();
				Mission missionObj=new Mission(missionName, missionDetails);
				missionUtilityObj.assignMissionToAvenger(missionsInShield,avengersInSquad,missionObj,avengerNames);
				break;
			case 3:
				System.out.println("Enter Mission Name: ");
				String checkMissionName=sc.nextLine();
				missionUtilityObj.checkMissionDetails(missionsInShield, checkMissionName);
				break;
			case 4:
				System.out.println("Enter Avenger Name: ");
				String checkAvengerName=sc.nextLine();
				missionUtilityObj.checkAvengerDetails(avengersInSquad, checkAvengerName);
				break;
			case 5:
				System.out.println("Enter Mission Name: ");
				String updateMissionName=sc.nextLine();
				System.out.println("Enter New Status: ");
				String status=sc.nextLine();
				missionUtilityObj.updateMissionstatus(missionsInShield, updateMissionName, status);
				break;
			case 6:
				missionUtilityObj.listAvengers(missionsInShield,avengersInSquad);
				break;
			default:
				break;
			}
		}while(choice!=7);
	}
}
