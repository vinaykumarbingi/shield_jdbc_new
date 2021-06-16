package com.shield.mission;

import java.util.List;

import com.shield.avenger.Avenger;

public class Mission {
	
	private String missionName;
	private String missionDetails;
	private List<Avenger> avengersAssignedToMission;
	private String missionStatus;
	
	public Mission(String missionName, String missionDetails) {
		super();
		this.missionName = missionName;
		this.missionDetails = missionDetails;
	}
	
	public String getMissionName() {
		return missionName;
	}
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}
	public String getMissionDetails() {
		return missionDetails;
	}
	public void setMissionDetails(String missionDetails) {
		this.missionDetails = missionDetails;
	}
	public List<Avenger> getAvengersAssignedToMission() {
		return avengersAssignedToMission;
	}
	public void setAvengersAssignedToMission(List<Avenger> avengersAssignedToMission) {
		this.avengersAssignedToMission = avengersAssignedToMission;
	}
	public String getMissionStatus() {
		return missionStatus;
	}
	public void setMissionStatus(String missionStatus) {
		this.missionStatus = missionStatus;
	}
}
