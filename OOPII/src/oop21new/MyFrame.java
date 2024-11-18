package oop21new;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.awt.*; 
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MyFrame extends JFrame 
implements ActionListener{
	
	
	static Connection db_con_obj = null;
	
	static PreparedStatement db_prep_obj = null;
	
	 // Components of the Form 
	   private Container c; 
	   private JLabel title; 
	   private JLabel name; 
	   private JTextField tname; 
	   private JLabel age; 
	   private JTextField tmno; 
	   private JLabel porpuse; 
	   private JRadioButton traveller; 
	   private JRadioButton tourist; 
	   private JRadioButton business; 
	   private ButtonGroup gengp; 
	   private JLabel critiria;
	   private JCheckBox rain;
	   private JCheckBox beach;
	   private JCheckBox mountain;
	   private JCheckBox museum;
	   private JCheckBox crb; 
	   private JLabel add; 
	   private JTextArea tadd; 
	   private JCheckBox term; 
	   private JButton sub; 
	   private JButton reset; 
	   private JButton table;
	   private JButton goldticket;
	   private JTextArea tout; 
	   private JLabel res; 
	   private JTextArea resadd; 
	 

	 
	   // constructor, to initialize the components 
	   // with default values. 
	    public MyFrame() 
	   {
	       setTitle("TICKETS"); 
	       setBounds(300, 90, 900, 700); 
	       setDefaultCloseOperation(EXIT_ON_CLOSE); 
	       setResizable(false); 
	 
	       c = getContentPane(); 
	       c.setLayout(null); 
	 
	       title = new JLabel("Form"); 
	       title.setFont(new Font("Arial", Font.PLAIN, 30)); 
	       title.setSize(300, 30); 
	       title.setLocation(300, 30); 
	       c.add(title); 
	 
	       name = new JLabel("Name"); 
	       name.setFont(new Font("Arial", Font.PLAIN, 20)); 
	       name.setSize(100, 20); 
	       name.setLocation(100, 100); 
	       c.add(name); 
	 
	       tname = new JTextField(); 
	       tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       tname.setSize(190, 20); 
	       tname.setLocation(200, 100); 
	       c.add(tname); 
	 
	       age = new JLabel("Age"); 
	       age.setFont(new Font("Arial", Font.PLAIN, 20)); 
	       age.setSize(100, 20); 
	       age.setLocation(100, 130); 
	       c.add(age); 
	 
	       tmno = new JTextField(); 
	       tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       tmno.setSize(40, 20); 
	       tmno.setLocation(200, 130); 
	       c.add(tmno); 
	 
	       porpuse = new JLabel("Porpuse"); 
	       porpuse.setFont(new Font("Arial", Font.PLAIN, 20)); 
	       porpuse.setSize(100, 20); 
	       porpuse.setLocation(100, 170); 
	       c.add(porpuse); 
	 
	       traveller = new JRadioButton("Traveller"); 
	       traveller.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       traveller.setSelected(true); 
	       traveller.setSize(100, 20); 
	       traveller.setLocation(200, 170); 
	       c.add(traveller); 
	 
	       tourist = new JRadioButton("Tourist"); 
	       tourist.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       tourist.setSelected(false); 
	       tourist.setSize(80, 20); 
	       tourist.setLocation(300, 170); 
	       c.add(tourist); 
	       business = new JRadioButton("Business"); 
	       business.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       business.setSelected(false); 
	       business.setSize(100 , 20); 
	       business.setLocation(200, 200); 
	       c.add(business);
	 
	       gengp = new ButtonGroup(); 
	       gengp.add(traveller); 
	       gengp.add(tourist); 
	       gengp.add(business); 
	 
	 
	       add = new JLabel("Cities you want to travel"); 
	       add.setFont(new Font("Arial", Font.PLAIN, 20)); 
	       add.setSize(250, 50); 
	       add.setLocation(100, 230); 
	       c.add(add); 
	 
	       tadd = new JTextArea(); 
	       tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       tadd.setSize(200, 100); 
	       tadd.setLocation(200, 270); 
	       tadd.setLineWrap(true); 
	       c.add(tadd); 
	       
	       
	       critiria = new JLabel("Cities' Critiria"); 
	       critiria.setFont(new Font("Arial", Font.PLAIN, 20)); 
	       critiria.setSize(200, 20); 
	       critiria.setLocation(100, 370); 
	       c.add(critiria); 
	       
	       rain = new JCheckBox("Include cities with rain"); 
	       rain.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       rain.setSelected(false); 
	       rain.setSize(250, 20); 
	       rain.setLocation(200, 390); 
	       c.add(rain); 
	       
	       beach = new JCheckBox("beaches"); 
	       beach.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       beach.setSelected(false); 
	       beach.setSize(250, 20); 
	       beach.setLocation(200, 410); 
	       c.add(beach); 
	       
	       mountain = new JCheckBox("mountains"); 
	       mountain.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       mountain.setSelected(false); 
	       mountain.setSize(250, 20); 
	       mountain.setLocation(200, 430); 
	       c.add(mountain); 
	       
	       museum = new JCheckBox("museums"); 
	       museum.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       museum.setSelected(false); 
	       museum.setSize(250, 20); 
	       museum.setLocation(200, 450); 
	       c.add(museum); 
	       
	       crb = new JCheckBox("cafe/bars/restuarants"); 
	       crb.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       crb.setSelected(false); 
	       crb.setSize(250, 20); 
	       crb.setLocation(200, 470); 
	       c.add(crb); 
	       
	       
	 
	       term = new JCheckBox("Accept Terms And Conditions."); 
	       term.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       term.setSize(250, 20); 
	       term.setLocation(150, 550); 
	       c.add(term); 
	 
	       sub = new JButton("Submit"); 
	       sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       sub.setSize(100, 20); 
	       sub.setLocation(150, 580); 
	       sub.addActionListener(this); 
	       c.add(sub); 
	 
	       reset = new JButton("Reset"); 
	       reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       reset.setSize(100, 20); 
	       reset.setLocation(270, 580); 
	       reset.addActionListener(this); 
	       c.add(reset); 
	       
	       
	       goldticket = new JButton("Free Ticket contest"); 
	       goldticket.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       goldticket.setSize(170, 20); 
	       goldticket.setLocation(500, 580); 
	       goldticket.addActionListener(this); 
	       c.add(goldticket);
	       
	       table = new JButton("Show Travellers"); 
	       table.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       table.setSize(150, 20); 
	       table.setLocation(700, 580); 
	       table.addActionListener(this); 
	       c.add(table);
	 
	       tout = new JTextArea(); 
	       tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       tout.setSize(300, 400); 
	       tout.setLocation(500, 100); 
	       tout.setLineWrap(true); 
	       tout.setEditable(false); 
	       c.add(tout); 
	 
	       res = new JLabel(""); 
	       res.setFont(new Font("Arial", Font.PLAIN, 10)); 
	       res.setSize(500, 50); 
	       res.setLocation(100, 500); 
	       c.add(res); 
	 
	       resadd = new JTextArea(); 
	       resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
	       resadd.setSize(200, 75); 
	       resadd.setLocation(580, 175); 
	       resadd.setLineWrap(true); 
	       c.add(resadd); 
	 
	       setVisible(true); 
	   } 
	 
	   // method actionPerformed() 
	   // to get the action performed 
	   // by the user and act accordingly 
	   public void actionPerformed(ActionEvent e) 
	   { String appid ="c1fd00d8e51552b3e923b76ba43fad35";
	       if (e.getSource() == sub) { 
	    	   int a = 0; 
	    	   a = Integer.parseInt(tmno.getText());
	    	   if(a<18) {
	               //tout.setText(""); 
	               //resadd.setText(""); 
	               //res.setText("You are underaged, the form witll be reseted");
	               
	               String def = ""; 
	               tname.setText(def); 
	               tadd.setText(def); 
	               tmno.setText(def); 
	               res.setText(def); 
	               tout.setText(def); 
	               term.setSelected(false); 
	               resadd.setText(def); 
	    		   
	    	   }
	           if (term.isSelected()) {
	        	   
	               //bring cites from base
	           	makeJDBCConnection() ;
	               ArrayList<City> citiesall = new ArrayList<City>();
	               try {
	       			citiesall = ReadData();
	       		} catch (SQLException d) {//I changed the name of the SQLException e to d
	       			// TODO Auto-generated catch block
	       			d.printStackTrace();
	       		}
	           	//bring cites from base
	               //cities he will choose
	               ArrayList<City> choosencities = new ArrayList<City>();
	             //cities he will choose
	               
	           	//bring the Travellers for the dat file
	          	 ArrayList<Traveller> trsall = new ArrayList<Traveller>();
	              
	            //bring the Travellers for the dat file
	          	 
	               try {
					trsall=readCollection("Travellers.dat");
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	               
	               
	               String data1; 
	               String data 
	                   = "Name : "
	                     + tname.getText() + "\n"
	                     + "Age : "
	                     + tmno.getText() + "\n";
	               String name = tname.getText();
	            
	              // System.out.print(a); 
	               if (traveller.isSelected()) 
	                   data1 = "Porpuse : Traveller"
	                           + "\n"; 
	               else if(tourist.isSelected())
	                   data1 = "Porpuse : Tourist"
	                           + "\n";
	               else
	            	   data1 = "Porpuse : Business"
	                           + "\n";
	       
	 
	               String data3 = "Cities : " + tadd.getText();
	               String tdata3 = tadd.getText();
	               String lines[] = tdata3.split("\\r?\\n");
	               for(int i=0;i<lines.length;i++) {
	            	   try {
	            	   String[] cityelem = lines[i].split(",", 2);
	      				String cityname = cityelem[0];
	      				String cityinit = cityelem[1];
	      				City buffer1;
						
							buffer1 = new City(cityname,cityinit,appid);
					
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
	            		} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            	   
	            	   
	               }
	               
	               
	               //System.out.print();
	               String data4="";
	               String data5="";
	               String data6="";
	               String data7="";
	               String data8="";
	               int[] choices= new int[] {0,0,0,0,0,0};
	               boolean rainwant = false;
	               tout.setEditable(false); 
	               res.setText("Success.."); 
	               if(beach.isSelected()) {
	            	   choices[0]=1;
	            	   data4 ="beach\n" ;}
	            	 //System.out.println("beach is selected");  
	               if(rain.isSelected()) {
	            	   rainwant=true;
	            	   data5="rain\n";}
	              	 //System.out.println("rain is selected");
	               if(mountain.isSelected()) {
	            	   choices[1]=1;
	            	   data6="mountain\n";}
	                	// System.out.println("mountain is selected");
	               if(museum.isSelected()) {
	            	   choices[2]=1;
	            	   data7="museum\n";}
	              	 //System.out.println("museum is selected");
	               if(crb.isSelected()) {
	            	   choices[3]=1;
	            	   choices[4]=1;
	            	   choices[5]=1;
	            	   data8="crb\n";
	               }
	               
	               City visit=null;
	               if (traveller.isSelected()) {
	            	   Traveller n1 = new Traveller(name,a, choices[3], choices[4], choices[5], choices[2], choices[1], choices[2],choosencities,rainwant,null);
				  		
	            	   if(n1.isRain() == true) {
			  				//he wants rain
	            		  //System.out.print(choosencities.get(0).getBars());
	            		  //System.out.print(choosencities.get(0).getCafe());
	            		  //System.out.print(choosencities.get(0).getMuseums());
	            		  //System.out.print(choosencities.get(0).getRestaurants());
	            
			  			visit =n1.CompaireCites(choosencities);
				  n1.setVisit(visit);//ADDING RECOMENDED CITY
				  trsall.add(n1);
				  
			  		}else if(n1.isRain() == false) {
			  			//he does not want rain
				  
			  			visit =n1.CompaireCites(choosencities, rainwant);
			  		}
	            	   
	               }else if(tourist.isSelected()) {
	            	   Tourist n1 = new Tourist(name,a, choices[3], choices[4], choices[5], choices[2], choices[1], choices[2],choosencities,rainwant,null);
	            	   
		  				if(n1.isRain() == true) {
		  					//he wants rain
		  					visit =n1.CompaireCites(choosencities);
		  					n1.setVisit(visit);//ADDING RECOMENDED CITY
		  					 trsall.add(n1);
				  
		  				}else if(n1.isRain() == false) {
				  //he does not want rain
				  
		  					visit =n1.CompaireCites(choosencities, rainwant);
			  	}
	               }else {
	            	   String s = (String)JOptionPane.showInputDialog(c,"Give us your current city,init");
	            	   
	            	   String[] cityelem = s.split(",", 2);
	      				String cityname = cityelem[0];
	      				String cityinit = cityelem[1];
	      				try {
							City current1 = new City(cityname,cityinit,appid);
							 Business n1 = new Business(name,a, choices[3], choices[4], choices[5],choices[2],choices[1],choices[2],choosencities,rainwant,null,current1.getLan(),current1.getLon());
							 
				  				if(n1.isRain() == true) {
				  					//he wants rain
				  					visit =n1.CompaireCites(choosencities);
						  
				  					
				  				}else if(n1.isRain() == false) {
				  					//he does not want rain
						  
				  					visit =n1.CompaireCites(choosencities, rainwant);
				  					n1.setVisit(visit);//ADDING RECOMENDED CITY
				  					 trsall.add(n1);
				  				}
							 
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	      				
	            	 
	               }
	               String data9=visit.getCityname();
	               
	               
	              	 //System.out.println("crb is selected");
	               tout.setText(data + data1 + data3+"\ncities critiria\n"+data4+data5+data6+data7+data8+"\nIdeal city:"+data9); 
	               try {
					writeCollection("Travellers.dat",trsall);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	           } 
	           else { 
	               tout.setText(""); 
	               resadd.setText(""); 
	               res.setText("You might be underaged or you havent"
	                           + " accepted the terms & conditions.."); 
	           } 
	       } 
	 
	       else if (e.getSource() == reset) { 
	           String def = ""; 
	           tname.setText(def); 
	           tadd.setText(def); 
	           tmno.setText(def); 
	           res.setText(def); 
	           tout.setText(def); 
	           term.setSelected(false);  
	           resadd.setText(def); 
	       } else if(e.getSource() == goldticket) {
	    	   
	    	   ArrayList<Traveller> trsall = new ArrayList<Traveller>();
	    	   
               try {
				trsall=readCollection("Travellers.dat");
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	   try {
				Traveller lucky = free_ticket(trsall);
				String message = "Gongrats\n"+lucky.getName()+"\nYou earned a FREE ticket\n to Corfu,gr ";
				tout.setText(message);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	   
	       }else if(e.getSource()== table) {
	    	   
	    	   
	    		JFrame f = new JFrame("Frame1");
	    		
	    		JPanel myPanel=new JPanel();
	    	   
	    	   ArrayList<Traveller> trsall = new ArrayList<Traveller>();
	    	   ArrayList<Traveller> nod = new ArrayList<Traveller>();
               try {
				trsall=readCollection("Travellers.dat");
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               nod = setandprint(trsall);
               String[] colums = {"name","age"};
               int nodsize = nod.size();
               Object[][] s = new Object[nodsize][2];
	    	   for(int i =0;i<nodsize;i++) {
	    		   
	    		   s[i][0]=nod.get(i).getName();
	    		   s[i][1]=nod.get(i).getAge();
	    	   }
	    	   DefaultTableModel dtm = new DefaultTableModel(s,colums);
	    	   JTable Trtable = new JTable(dtm);
	    	   JScrollPane jsp2 = new JScrollPane();
	    	   jsp2.getViewport().add(Trtable);
	    	   myPanel.add(jsp2);
	    	   jsp2.setBounds(10,300,200,100);
	    	   jsp2.setVisible(true);
	    		f.setContentPane(myPanel);
	    		f.setSize(550,280); 
	    		f.setVisible(true);
	    	
	       }
	   } 
	   
//FOR TRAVELLERS=====================================================================

//BELOW

 //FOR TRAVELLERS=====================================================================	

		  
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
	   
	   
	   

//FOR JDBC=====================================================================

//BELOW

//FOR JDBC=====================================================================
	   
	   
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
		
//GOLDEN TICKET=====================================================================

//BELLOW

//GOLDEN TICKET=====================================================================
		
	    public Traveller free_ticket(ArrayList<Traveller> travellers) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
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
	    	return travellers.get(maxi);
	    	//System.out.printf("congrats %s you won a free ticket to %s ", travellers.get(maxi).getName(), freecity.getCityname());
	    	
	    }
	    
	  //About Traveller table=====================================================================

	  //BELLOW

	  //About Traveller table=====================================================================
	    
	    
	    
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
			 
			public static ArrayList<Traveller> setandprint(ArrayList<Traveller> tr) {

				
				Collections.sort(tr);
			int max=tr.size();
			ArrayList<Traveller> set = new ArrayList<Traveller>();

			for(int i = 0; i < max; i++){
				if(!(find_traveller(tr.get(i).getName(),tr.get(i).getAge() ,tr)))
				  set.add(tr.get(i));
				}
			Iterator<Traveller> it = set.iterator();
			//while(it.hasNext()) {
				// Traveller e = it.next();
		//	  System.out.println(e.getName()+"\t"+e.getAge()+"\n");
			//}
				return set;
			}

		}





