package com.shield.avengerImpl;

import com.shield.avenger.Avenger;

public class Thor implements Avenger{
	
	public String avengerName="Thor";
	public String personName="Chris Hemsworth";
	public String avengerAbilities="God of thunder";
	public int missionAssigned=0;
	public int missionCompleted=0;
	public String avengerStatus="Available";
	public String getAvengerStatus() {
		return avengerStatus;
	}

	public void setAvengerStatus(String avengerStatus) {
		this.avengerStatus = avengerStatus;
	}

	@Override
	public void getMissionAssignAlert() {
		System.out.println("Sms is sent to Thor");
	}

	public String getAvengerName() {
		return avengerName;
	}

	public void setAvengerName(String avengerName) {
		this.avengerName = avengerName;
	}
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getAvengerAbilities() {
		return avengerAbilities;
	}

	public void setAvengerAbilities(String avengerAbilities) {
		this.avengerAbilities = avengerAbilities;
	}

	public int getMissionAssigned() {
		return missionAssigned;
	}

	public void setMissionAssigned(int missionAssigned) {
		this.missionAssigned = missionAssigned;
	}

	public int getMissionCompleted() {
		return missionCompleted;
	}

	public void setMissionCompleted(int missionCompleted) {
		this.missionCompleted = missionCompleted;
	}

	
}
