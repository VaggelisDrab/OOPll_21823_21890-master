/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop21new;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import weather.OpenWeatherMap;
import wikipedia.MediaWiki;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elise
 */
public class OOP21new {
	//static Connection db_con_obj = null;
	
	//static PreparedStatement db_prep_obj = null;

    public static void main(String[] args) throws  IOException, ClassNotFoundException {
    	//String appid ="c1fd00d8e51552b3e923b76ba43fad35";
    	MyFrame f=new MyFrame();
    	/*
    	//bring the Travellers for the dat file
    	 ArrayList<Traveller> trsall = new ArrayList<Traveller>();
        
      //bring the Travellers for the dat file
        
        //bring cites from base
    	makeJDBCConnection() ;
        ArrayList<City> citiesall = new ArrayList<City>();
        try {
			citiesall = ReadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//bring cites from base
        ArrayList<City> choosencities = new ArrayList<City>();
        
    	Scanner decimals = new Scanner(System.in);
        Scanner strings = new Scanner(System.in);
        
      

        City tria = new City("Rome","it",appid);
       
       
        Traveller trial = new Traveller("mary",20, 1, 1, 1, 1, 1, 1,citiesall,true,null);//we have to removeit
        trsall.add(trial);
       // writeCollection("Travellers.dat",trsall);
        
        trsall.add(trial);
        citiesall.add(tria);
        //addDataToDB("Rome","it");
        trsall=readCollection("Travellers.dat");
        
       System.out.println("Welcome! Please provide us your purpose:\n1. Traveller\t2. Tourist\t3. Business");
       String type;
       		do {
       			type = strings.nextLine();
       				if(type.equals("1") || type.equals("2") || type.equals("3")) {break;}
       		}while(true);

       		
       		int age=0;
       		String name=null;
       	do {	
       System.out.println("Please provide your name:\n");
       name = strings.nextLine();
       
      
      System.out.println("Please provide your age:\n");
       
      		//do {
      			age = decimals.nextInt();
      				if(age<18 && age >120) {
      					System.out.println("unable to travel\n");
      				}else {
      					break;
      				}		
    	  
      		}while(true);
      		
      		/*if(find_traveller(name, age,trsall )) {
      			System.out.println("You exist, It isnt you?Try again\n");
      		}else {
      			break;
      		}
      		
       	//}while(true);
      System.out.println("Please provide us your preffered cities (in the following form \"City_name, City_initials\") Press \"exit\" for EXIT\n");
      String citystr = null;
      
      	while(true) {
      		citystr = strings.nextLine();
    	  
    	 //hello
      		if(citystr.equals("exit")) {
    		  break;
      		}else {
      			try {
      				String[] cityelem = citystr.split(",", 2);
      				String cityname = cityelem[0];
      				String cityinit = cityelem[1];
      				City buffer1 = new City(cityname,cityinit,appid);
      				//System.out.printf("%s", buffer1.getCountry());
      				//System.out.printf("%s", buffer1.getArticle());
      				//OVERRIDING EQUALS
      				if(buffer1.equals(buffer1, citiesall)) {
      					System.out.println("it does exist IN THE BASE\n");
      					//int pos=citiesall.indexOf(buffer1);
      					choosencities.add(buffer1);
      					
      					continue;
      				}else {
      				
      				citiesall.add(buffer1);
      				choosencities.add(buffer1);
      				addDataToDB(buffer1.getCityname(),buffer1.getCountry());
      				
      				}
    		  }catch(ArrayIndexOutOfBoundsException exception) {
    			  	System.out.println("Your input didn't include a comma, follow the given form.");
    		  }
    		
    	 }//end of if 
      	}//end of while  
      System.out.println("How many people are traveling?\n");
      int people = decimals.nextInt();
      
      
      
      System.out.println("Do you want to include cites with Rain ?Answer with 1 for yes or 0 for no ");
      boolean rain;
    		  int wantrain = 0;
    		  	do {wantrain = decimals.nextInt();}while(wantrain != 1 && wantrain!= 0);
    		  		if(wantrain == 0) {
    			  rain = false;}else {
    				  rain = true;									
    				}
      
    		  			//true is yes 
    		  			//false is no 
      
      
      
       System.out.println("Would like the place you will travel to have a beach? Type (1) for YES or (0) for NO\n ");
        int beach =0 ;
        		  do{
        			  beach=decimals.nextInt();
        		  }while(beach != 1 && beach !=0);
        		  
        		  
        System.out.println("Would like the place you will travel to have a mountains? Type (1) for YES or (0) for NO\n");
          int mountain =0 ;
		  	do{
		  		mountain=decimals.nextInt();
		  	}while(mountain != 1 && mountain !=0);
          
        System.out.println("would you like to see museums? Type (1) for YES or (0) for NO\n");
          int mus = 0; 
		  do{
			     mus=decimals.nextInt();
		  }while(mus != 1 && mus !=0);          
          
        System.out.println("would like to have cafe/restuarants/bars near your place? Type (1) for YES or (0) for NO\n");
          int crb = 0;
		  	do{
			     crb=decimals.nextInt();
		  	}while(crb != 1 && crb !=0);          
       
		  int cafe= 0;
		  int res = 0;
		  int bar = 0;
		  	if(crb ==1) {
		  		cafe= 1;
		  		res = 1;
		  		bar = 1;
		  	}
		  	
		  City visit; 
		  		if(type.equals("1")){
		  			Traveller n1 = new Traveller(name,age, cafe, bar, res, beach, mountain, mus,choosencities,rain,null);
			  		if(n1.isRain() == true) {
			  				//he wants rain
			  			visit =n1.CompaireCites(choosencities);
				  n1.setVisit(visit);//ADDING RECOMENDED CITY
				  trsall.add(n1);
				  
			  		}else if(n1.isRain() == false) {
			  			//he does not want rain
				  
			  			visit =n1.CompaireCites(choosencities, rain);
			  		}
		  		}else if(type.equals("2")) {
		  			Tourist n1 = new Tourist(name,age, cafe, bar, res, beach, mountain, mus,choosencities,rain,null);
			  
		  				if(n1.isRain() == true) {
		  					//he wants rain
		  					visit =n1.CompaireCites(choosencities);
		  					n1.setVisit(visit);//ADDING RECOMENDED CITY
		  					 trsall.add(n1);
				  
		  				}else if(n1.isRain() == false) {
				  //he does not want rain
				  
		  					visit =n1.CompaireCites(choosencities, rain);
			  	}
			  
		  		}else {
		  			System.out.println("tell the city you wil be aboarded with the same way as you type the cities\n");
		  			citystr = strings.nextLine();
		  			String str = citystr;
		  			String[] cityelem = str.split(",", 2);
		  			String cityname = cityelem[0];
		  			String cityinit = cityelem[1];
		  			City bis = new City(cityname,cityinit,appid);
			  
		  			Business n1 = new Business(name,age, cafe, bar, res, beach, mountain, mus,choosencities,rain,null,bis.getLan(),bis.getLon());
			  
		  				if(n1.isRain() == true) {
		  					//he wants rain
		  					visit =n1.CompaireCites(choosencities);
				  
		  					
		  				}else if(n1.isRain() == false) {
		  					//he does not want rain
				  
		  					visit =n1.CompaireCites(choosencities, rain);
		  					n1.setVisit(visit);//ADDING RECOMENDED CITY
		  					 trsall.add(n1);
		  				}
		  		}//end of type of travellers
		  //we save the data of new travellers
		  		
		  		//free_ticket(trsall);
		  		writeCollection("Travellers.dat",trsall);
		  		
		  		setandprint(trsall);
		  		*/
    	  
      }
 //************************************************************************
    
    //END OF MAIN
    
 //************************************************************************
    //free ticket takes and array of travellers and gives the ticket to the person with the 
    /*
    public void free_ticket(ArrayList<Traveller> travellers) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
    	String appid ="c1fd00d8e51552b3e923b76ba43fad35";
    	

    	City freecity= new City("Corfu","gr",appid);   //in freecity object you need to retrieve data so free_ticket can work, so it must NOT be NULL 

    	int i;
    	double[] per = new double [travellers.size()];
    		for(i=0; i< travellers.size(); i++) {
    			per[i]=travellers.get(i).Similarity(freecity);
    		
    		}
    	double max = 0;
    	int maxi = 0;
    	for(i = 0; i < travellers.size(); i++) {
    		if(per[i]>max) {
    			max = per[i]; 
    			maxi = i;
    		}
    		
    	}

    	System.out.printf("congrats %s you won a free ticket to %s ", travellers.get(maxi).getName(), freecity.getCityname());
    	
    }
  //************************************************************************
    
    //STARTS ASSIGMENT 2
    

  //FOR TRAVELLERS=====================================================================
 public static boolean find_traveller(String name,int age, ArrayList<Traveller> tr) {
	 int timesfound=0;
	 if(tr.size()==0) {
		 return false;
	 }else {
	 for(int i=0; i<tr.size(); i++) {
		 
		 if(tr.get(i).getName().equals(name) && tr.get(i).getAge()==age) {
			timesfound++;
		 }
		 
	 }
	 }
		//System.out.println(timesfound);
	 return (timesfound>1);
 }
 
public static void setandprint(ArrayList<Traveller> tr) {

	
	Collections.sort(tr);
int max=tr.size();
ArrayList<Traveller> set = new ArrayList<Traveller>();

for(int i = 0; i < max; i++){
	if(!(find_traveller(tr.get(i).getName(),tr.get(i).getAge() ,tr)))
	  set.add(tr.get(i));
	}
Iterator<Traveller> it = set.iterator();
while(it.hasNext()) {
	 Traveller e = it.next();
  System.out.println(e.getName()+"\t"+e.getAge()+"\n");
}
	
}
  
public static void writeCollection(String TravellersFileName,ArrayList<Traveller> trsall) throws IOException {
    
	//ArrayList<Traveller> trsall = new ArrayList<Traveller>();
	

    FileOutputStream out = new FileOutputStream(TravellersFileName);
    ObjectOutputStream oout = new ObjectOutputStream(out);

    // write something in the file
    oout.writeObject(trsall);
    oout.flush();
    oout.close();
    System.out.println("Data are writen in the file.");
}  


public static ArrayList<Traveller> readCollection(String TravellersFileName) throws FileNotFoundException, IOException, ClassNotFoundException {
	ObjectInputStream ois;
	//System.out.println("I am in");
	ois = new ObjectInputStream(new FileInputStream(TravellersFileName));
    // read and print what we wrote before
	//System.out.println("I am in");
	//Traveller inShop_1 = (Traveller) ois.readObject();
	//System.out.println("here:"+inShop_1.getName());
	ArrayList<Traveller> trsall = new ArrayList<Traveller>();
	trsall = (ArrayList<Traveller>)ois.readObject();
	//System.out.println("I am in"); 
	
	
	//System.out.println("I am in"+ trsall.get(0).getAge());
	
    ois.close();
    return trsall;
}

//FOR TRAVELLERS=====================================================================



//FOR TRAVELLERS=====================================================================
private static void makeJDBCConnection() {
	 
	try {//We check that the DB Driver is available in our project.		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //This code line is to check that JDBC driver is available. Or else it will throw an exception. Check it with 2. 
		System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!"); 
	} catch (ClassNotFoundException e) {
		System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
		e.printStackTrace();
		return;
	}

	try {
		// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
		db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","it21823","it21823");// Returns a connection to the URL.
		//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
		if (db_con_obj != null) { 
			System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
			
		} else {
			System.out.println("Failed to make connection!");
		}
	} catch (SQLException e) {
		System.out.println("MySQL Connection Failed!");
		e.printStackTrace();
		return;
	}

}
 
public static ArrayList<City> ReadData() throws SQLException {
db_prep_obj = db_con_obj.prepareStatement("select * from CITY");
ResultSet  rs = db_prep_obj.executeQuery();
ArrayList<City> citiesall = new ArrayList<City>();
while (rs.next()){
    String cityName = rs.getString("cityname");
    String cityinit = rs.getString("cityinit");
    try {
		City buffer = new City(cityName,cityinit,"c1fd00d8e51552b3e923b76ba43fad35");
		citiesall.add(buffer);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}
return citiesall;

}

private static void addDataToDB(String Cityname, String cityinit) {
	// System.out.println(cityinit);
	try {
		String insertQueryStatement = "INSERT  INTO  CITY  VALUES  (?,?)";
		
		//static Connection db_con_obj = null;
		//static PreparedStatement db_prep_obj = null;
		
		db_prep_obj = db_con_obj.prepareStatement(insertQueryStatement);
		db_prep_obj.setString(1, Cityname);
		db_prep_obj.setString(2, cityinit);
		// execute insert SQL statement Executes the SQL statement in this PreparedStatement object, which must be an SQL Data Manipulation Language (DML) statement
		int numRowChanged = db_prep_obj.executeUpdate(); //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
		System.out.println("Rows "+numRowChanged+" changed.");
		
	} catch (

	SQLException e) {
		e.printStackTrace();
	}
}
*/
}
