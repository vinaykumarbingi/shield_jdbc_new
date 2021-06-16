package com.shield.utility;

import java.util.ArrayList;
import java.util.List;

import com.shield.avenger.Avenger;
import com.shield.mission.Mission;

public class MissionUtility {
	
	public void listShieldMissions(List<Mission> missionList)
	{
		if(missionList.size()==0)
		{
			System.out.println("No Mission has been assigned to an Avenger.\n");
			return;
		}
		missionList.stream().forEach(mission->{
			System.out.print("Mission Name: "+mission.getMissionName()+"\nStatus: "+mission.getMissionStatus()+"\nAvengers: ");
			List<String> listOfAvenger=new ArrayList<>();
			for(Avenger av: mission.getAvengersAssignedToMission())
			{
				listOfAvenger.add(av.getAvengerName());
			}
			System.out.print(String.join(",", listOfAvenger));
			System.out.println("\n-----------------------------------------------------------------------");
		});
	}
	
	public void assignMissionToAvenger(List<Mission> missionList, List<Avenger> avengersInSquad, Mission missionObj, String avengerNames)
	{
		String[] avengerNamesArr=avengerNames.split(", ");
		List<Avenger> avengers=new ArrayList<Avenger>();
		for(String avengerName: avengerNamesArr)
		{
			Avenger avengerObj=AvengerUtility.getAvengerInstance(avengerName);
			if(avengerObj==null)
			{
				System.out.println("No avenger with the name "+avengerName+" present in the SHIELD Squad.\n");
				return;
			}
			if(avengerObj.getMissionAssigned()>1)
			{
				System.out.println("Sorry, "+avengerObj.getAvengerName()+" has already been working on two missions.\n");
				return;
			}
			avengers.add(avengerObj);
		}
		missionObj.setAvengersAssignedToMission(avengers);
		missionObj.setMissionStatus("Assigned");
		System.out.println("Mission has been assigned.");
		avengers.stream().forEach(avenger-> avenger.getMissionAssignAlert());
		for(String avengerName: avengerNamesArr)
		{
			Avenger avengerObj=AvengerUtility.getAvengerInstance(avengerName);
			avengerObj.setMissionAssigned(avengerObj.getMissionAssigned()+1);
		}
		missionList.add(missionObj);
		System.out.println();
		System.out.println("\n-----------------------------------------------------------------------");
	}
	public void checkMissionDetails(List<Mission> missionList, String missionName)
	{
		
		
		missionList.stream().forEach(mission->{
			if(mission.getMissionName().equals(missionName))
			{
				System.out.println("Mission Details: "+mission.getMissionDetails());
				System.out.println("Mission Status: "+mission.getMissionStatus());
				System.out.print("Avengers: ");
				List<String> listOfAvenger=new ArrayList<>();
				for(Avenger av: mission.getAvengersAssignedToMission())
				{
					listOfAvenger.add(av.getAvengerName());
				}
				System.out.print(String.join(",", listOfAvenger));
			}
			
		});
			
			System.out.println("\n-----------------------------------------------------------------------");
		
		
	}
	public void checkAvengerDetails(List<Avenger> avengersInSquad, String avengerName)
	{
		
		Avenger avengerObj=AvengerUtility.getAvengerInstance(avengerName);
		if(avengerObj==null)
		{
			System.out.println("No avenger with the name "+avengerName+" present in the SHIELD Squad.\n");
			return;
		}
		else
		{
			System.out.println("Person Name: "+avengerObj.getPersonName());
			System.out.println("Abilities: "+avengerObj.getAvengerAbilities());
			System.out.println("Mission Assigned: "+avengerObj.getMissionAssigned());
			System.out.println("Mission Completed: "+avengerObj.getMissionCompleted());
		}
		System.out.println("\n-----------------------------------------------------------------------");
	}
	public void updateMissionstatus(List<Mission> missionList, String missionName, String status)
	{
		missionList.stream().forEach(mission->{
			if(mission.getMissionName().equals(missionName))
			{
				mission.setMissionStatus(status);
				for(Avenger av: mission.getAvengersAssignedToMission())
				{
					av.setMissionCompleted(av.getMissionCompleted()+1);
					av.setMissionAssigned(av.getMissionAssigned()-1);
					av.getMissionAssignAlert();	
				}
			}
		});
		System.out.println("\n-----------------------------------------------------------------------");
	}
	public void listAvengers(List<Mission> missionList, List<Avenger> avengersInSquad)
	{
		
		avengersInSquad.stream().forEach(avenger->{
			System.out.println("Avenger Name: "+avenger.getAvengerName());
			if(avenger.getMissionAssigned()>0)
			{
			    
			    avenger.setAvengerStatus("On Mission");
				System.out.println("Status: "+avenger.getAvengerStatus());
			}
			else
			{
				avenger.setAvengerStatus("Available");
				System.out.println("Status: "+avenger.getAvengerStatus());
			}
			List<String> listOfMissions=new ArrayList<>();
			System.out.print("Assigned Missions: ");
			missionList.stream().forEach(mission->{
				
				for(Avenger av: mission.getAvengersAssignedToMission())
				{
					
					if(av.getAvengerName().equals(avenger.getAvengerName()))
					{
						
						listOfMissions.add(mission.getMissionName());
					}
				}
				
			});
			System.out.print(String.join(",", listOfMissions));
			
			System.out.println("\n-----------------------------------------------------------------------");
		});
	}
}
