package com.shield.utility;

import java.util.ArrayList;
import java.util.List;

import com.shield.avenger.Avenger;
import com.shield.avengerImpl.BlackWidow;
import com.shield.avengerImpl.CaptainAmerica;
import com.shield.avengerImpl.Hawkeye;
import com.shield.avengerImpl.Hulk;
import com.shield.avengerImpl.IronMan;
import com.shield.avengerImpl.Thor;

public class AvengerUtility {
	
	private static BlackWidow blackWidow=new BlackWidow();
	private static CaptainAmerica captainAmerica=new CaptainAmerica();
	private static Hawkeye hawkeye=new Hawkeye();
	private static Hulk hulk=new Hulk();
	private static IronMan ironMan=new IronMan();
	private static Thor thor=new Thor();
	
	public static List<Avenger> getAllAvengersInSquad()
	{
		List<Avenger> avengers=new ArrayList<Avenger>();
		avengers.add(blackWidow);
		avengers.add(captainAmerica);
		avengers.add(hawkeye);
		avengers.add(hulk);
		avengers.add(ironMan);
		avengers.add(thor);
		return avengers;
	}
	
	public static Avenger getAvengerInstance(String avengerName)
	{
		if(avengerName.toLowerCase().equals("hulk"))
		{
			return hulk;
		}
		else if(avengerName.toLowerCase().equals("black widow"))
		{
			return blackWidow;
		}
		else if(avengerName.toLowerCase().equals("captain america"))
		{
			return captainAmerica;
		}
		else if(avengerName.toLowerCase().equals("hawkeye"))
		{
			return hawkeye;
		}
		else if(avengerName.toLowerCase().equals("iron man"))
		{
			return ironMan;
		}
		else if(avengerName.toLowerCase().equals("thor"))
		{
			return thor;
		}
		return null;
	}
	
}
