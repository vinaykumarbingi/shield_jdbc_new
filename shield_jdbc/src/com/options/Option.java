package com.options;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dbconnection.DatabaseConnection;


public class Option 
{
	static Connection con = DatabaseConnection.getConnection();
	//1
	public static void checkTheMissions()
	{
		try 
		{
		String query="select * from mission";
		Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()==false)
        {
        	System.out.println("No Mission has been assigned to an Avenger.");
        	System.out.println("--------------------------------------------");
        	return;
        }
        
        ResultSet rs1 = st.executeQuery(query);
        while(rs1.next())
        {
        	
          System.out.println("mission name: "+rs1.getString(1));
          System.out.println("mission Stauts: "+rs1.getString(3));
          System.out.println("Avengers: "+rs1.getString(4));
          System.out.println("--------------------------------");
         }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//2
	public static void assignMissionToAvenger(String avengerNames, String missionName, String missionDetails)
	{
		String[] avengerNamesArr=avengerNames.split(", ");
		try 
		{
		
		for(String avengerName: avengerNamesArr)
		{
			String query="select * from avengers";
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(query);
			int count=0;
			while(rs.next())
			{
				
				if(rs.getString(1).equals(avengerName))
				{
					count++;
					if(rs.getInt(4)>1)
					{
						System.out.println("Sorry, "+avengerName+" has already been working on two missions.\n");
						System.out.println("---------------------------------------------------");
						return;
					}
					if(count==1)
					{
						
						PreparedStatement st2 = (PreparedStatement)con.prepareStatement("UPDATE avengers SET missionAssigned =?, avengerStatus=? WHERE name=?");
						st2.setInt(1,rs.getInt(4)+1);
						st2.setString(2,"On Mission");
						st2.setString(3,rs.getString(1));
						st2.executeUpdate();
						System.out.println("mission assigned and email and sms sent to "+rs.getString(1));
					}
				}

			}
			
			if(count==0)
			{
				System.out.println("No avenger with the name "+avengerName+" present in the SHIELD Squad.\n");
				return;
			}
			else if(count==2)
			{
				System.out.println("one avenger cannot be assigned two times for one mission");
				return;
			}
		}
		PreparedStatement st = (PreparedStatement)con.prepareStatement("insert into mission values (?,?,?,?)");
		st.setString(1, missionName);
		st.setString(2, missionDetails);
		st.setString(3, "Assigned");
		st.setString(4, avengerNames);
		st.executeUpdate();
		//System.out.println(i);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//3
	public static void checkMissionDetails(String checkMissionName)
	{
		
		try 
		{
			String query="select * from mission";
			Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while(rs.next())
	        {
	        	if(rs.getString(1).equals(checkMissionName))
	        	{
	        		System.out.println("Mission Details: "+rs.getString(2));
	        		System.out.println("Mission Status: "+rs.getString(3));
	        		System.out.println("Avengers: "+rs.getString(4));
	        		System.out.println("--------------------------------");
	        	}
	        }
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//4
	public static void checkAvengerDetails(String checkAvengerName)
	{
		
		try 
		{
			String query="select * from avengers";
			Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        
	        while(rs.next())
	        {
	        	if(rs.getString("name").equals(checkAvengerName))
	        	{
	        		System.out.println("person name: "+rs.getString(2));
	        		System.out.println("Abilities: "+rs.getString(3));
	        		System.out.println("Mission Assigned: "+rs.getInt(4));
	        		System.out.println("Mission Completed: "+rs.getInt(5));
	        		System.out.println("--------------------------------");
	        	}
	          
	         
	         }
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//5
	public static void updateMissionstatus(String updateMissionName,String status)
	{
	
		try 
		{
			String query="select * from mission";
			Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        if(rs.next()==false)
	        {
	        	System.out.println("No Mission has been assigned to an Avenger. add mission");
	        	System.out.println("--------------------------------------------");
	        	return;
	        }
	        int count =0;
	        ResultSet rs1 = st.executeQuery(query);
	        while(rs1.next())
	        {
	        	
	        	if(rs1.getString(1).equals(updateMissionName))
	        	{
	        		count++;
	        		PreparedStatement st1= (PreparedStatement)con.prepareStatement("UPDATE mission set missionStatus=? WHERE missionName=?");
	    			st1.setString(1, status);
	    			st1.setString(2, updateMissionName);
	    			st1.executeUpdate();
	    			System.out.println("email and sms send to "+rs1.getString(4));
	    			
	    			String[] avengerNamesArr=rs1.getString(4).split(", ");
	    			
	    			String query2="select * from avengers";
    				Statement st2 = con.createStatement();
    				
	    			for(String avengerName:avengerNamesArr)
	    			{
	    				
	    		        ResultSet rs2 = st2.executeQuery(query2);
	    		        while(rs2.next())
	    		        {
	    		        	if(rs2.getString(1).equals(avengerName))
	    		        	{
	    		        		PreparedStatement st3= (PreparedStatement)con.prepareStatement("update avengers set missionAssigned=?, missionCompleted=?  where name=?");
	    		        		st3.setInt(1,rs2.getInt(4)-1);
	    		        		st3.setInt(2, rs2.getInt(5)+1);
	    		        		st3.setString(3,rs2.getString(1));
	    		        		st3.executeUpdate();
	    		        	}
	    		        }
	    			}
	    			
	        	}
	        	
	        }
	        if(count==0)
	        {
	        	System.out.println("no mission name with "+updateMissionName);
	        	System.out.println("-----------------------------------------");
	        }
	        
	        String query9="select * from avengers";
			Statement st9 = con.createStatement();
	        ResultSet rs9 = st9.executeQuery(query9);
	        while(rs9.next())
	        {
	        	if(rs9.getInt(4)<1)
	    		{
	    			PreparedStatement st10= (PreparedStatement)con.prepareStatement("update avengers set avengerStatus=?  where name=?");
	    			st10.setString(1,"Available");
	    			st10.setString(2,rs9.getString(1));
	    			st10.executeUpdate();
	    		}
	        }
	        
			
			
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//6
	public static void listAvengers()
	{
		
		try 
		{
			String query="select * from avengers";
			Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        
	        String q="select * from mission";
	        Statement st1=con.createStatement();
	        
	        
	        
	        while(rs.next())
	        {
	          System.out.println("Avenger name: "+rs.getString(1));
	          System.out.println("Avenger Stauts: "+rs.getString(6));
	          String name=rs.getString(1);
	          ResultSet rs1=st1.executeQuery(q);
	          while(rs1.next())
	          {
	        	  String avengerNames=rs1.getString(4);
	        	  String[] avengerNamesArr=avengerNames.split(", ");
	        	  for(String avengerName: avengerNamesArr)
	        	  {
	        		  if(name.equals(avengerName))
	        		  {
	        			  System.out.println("Assigned mission: "+rs1.getString(1));
	        		  }
	        	  }
	        	  
	          }
	          System.out.println("--------------------------------");
	         }
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//7
	public static void addAvengers(String avengerName, String personName, String abilities) 
	{
		try
		{
			String query="select name from avengers;";
			Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        
	        while(rs.next())
	        {
	        	if(rs.getString("name").equals(avengerName))
	        	{
	        		System.out.println("Already "+avengerName+"avenger exists, enter new avenger.");
	        		System.out.println("---------------------------------------------");
	        		return;
	        	}
	        }
	        String query1="insert into avengers values (?,?,?,?,?,?)";
	        PreparedStatement st1 = (PreparedStatement)con.prepareStatement(query1);
	        st1.setString(1, avengerName);
	        st1.setString(2, personName);
	        st1.setString(3, abilities);
	        st1.setInt(4, 0);
	        st1.setInt(5, 0);
	        String avengerStatus="Available";
	        st1.setString(6,avengerStatus);
	        st1.executeUpdate();
	        System.out.println("-------------------------------");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
