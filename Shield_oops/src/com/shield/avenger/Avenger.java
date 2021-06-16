package com.shield.avenger;

public interface Avenger {
	
	public void getMissionAssignAlert();
	public String getAvengerName();
	public String getPersonName();
	public String getAvengerStatus();
	public void setAvengerStatus(String avengerStatus);
	public String getAvengerAbilities();
	public int getMissionAssigned();
	public int getMissionCompleted();
	public void setMissionAssigned(int missionAssigned);
	public void setMissionCompleted(int missionCompleted);
}
