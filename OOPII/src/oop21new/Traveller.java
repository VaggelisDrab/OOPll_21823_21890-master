/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop21new;

import java.util.*;

/**
 *
 * @author elise
 */
public class Traveller implements Comparable<Traveller>,java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    protected int cafe;
    protected int res;
    protected int bar;
    protected int beach;
    protected int mountain;
    protected int mus;
    private boolean rain;
    private ArrayList<City> cities;
    protected City visit;
    
    
 



	public Traveller(String name, int age, int cafe, int bar, int res, int beach, int mountain ,int mus, ArrayList<City> cities, boolean rain, City visit) {
        this.name = name;
        this.age = age;
        this.cafe = cafe;
        this.mus = mus;
        this.cities = cities;
        this.bar = bar;
        this.res = res;
        this.beach = beach;
        this.mountain = mountain;
        this.rain = rain;
        this.visit = visit;
      
    }
    
    
    
    
    

    public int getRes() {
		return res;
	}



	public void setRes(int res) {
		this.res = res;
	}



	public int getBar() {
		return bar;
	}



	public void setBar(int bar) {
		this.bar = bar;
	}



	public int getBeach() {
		return beach;
	}



	public void setBeach(int beach) {
		this.beach = beach;
	}



	public int getMountain() {
		return mountain;
	}



	public void setMountain(int mountain) {
		this.mountain = mountain;
	}



	public boolean isRain() {
		return rain;
	}


	public void setRain(boolean rain) {
		this.rain = rain;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    public int getMus() {
        return mus;
    }

    public void setMus(int mus) {
        this.mus = mus;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }
    
    
    public City getVisit() {
 		return visit;
 	}






 	public void setVisit(City visit) {
 		this.visit = visit;
 	}



    
    /** Counts distinct words in the input String.
    @param str The input String. 
    @return An integer, the number of distinct words.
    */	
    public static int countDistinctWords(String str) {
    //	System.out.print(str);
    	String s[]=str.split(" ");
    	ArrayList<String> list=new ArrayList<String>();
    	
    	for (int i = 1; i < s.length; i++) {
    	    if (!(list.contains(s[i]))) {
    	        list.add(s[i]);
    	    }
    	}
    	return 	list.size();
    }
    
    
    
    public double Similarity(City e){
    	
    	System.out.printf("%s\n", e.getCityname());
    	int distinctwords = countDistinctWords(e.getArticle());
    	 
    	double yes = 0;
    	if(e.getBeaches() != 0 && beach != 0 ) {
    	   yes++;
    	}
    	if(e.getMountains() != 0 && mountain !=0 ) {
    		yes++;
    	}
    	if(e.getCafe() != 0 && cafe !=0) {
    		yes++;
    	}
    	if(e.getMuseums()!= 0 && mus != 0 ) {
    		yes++;
    	}
    	if(e.getBars()!= 0 ) {
    		yes++;
    	}
    	if(e.getRestaurants()!=0 && res != 0) {
    		yes++;
    	}
    	
    	int l = distinctwords;
    	
         double k = (yes * 100)/ l ;
         
         double i = new Double(k);
    	return i;
    }

    
    
    public City CompaireCites (ArrayList<City> e){  
    	
        
        double[] al = new double [e.size()];
       
        
        for ( int i=0; i< e.size();i++){
        	
            al[i] = Similarity(e.get(i));
           	
             
            
        }
        for (int i=0;i< e.size();i++) {
        	
        }
        
        double max = 0;
        int maxp = 0;
        for(int i =0; i<e.size(); i++) {
        	if(max< al [i]) {
        		max = al [i]; 
        	    maxp = i;
        	    
        	    }
        	
        
        }
        System.out.printf("perfect city for you is %s with similarity by %f\n ", e.get(maxp).getCityname(),al[maxp]);
        return e.get(maxp);
    }
    
   
    public City CompaireCites (ArrayList<City> e, boolean rain){  
        
        double[] al = new double [e.size()];
        
        
        for(int i=0;i< e.size(); i++){
            
            double per = Similarity(e.get(i));
            if(e.get(i).getWeather() == "rain") {
            	
            	continue;
            }else {
            	al [i] = per;
            }
            	
           
            
       }
        double max = 0;
        int maxp = 0;
        for(int i =0; i<e.size(); i++) {
        	if(max< al [i]) {
        		max = al [i]; 
        	    maxp = i;
        	    
        	    }
        	
        
        }
        System.out.printf("perfect city for you is %s with similarity by %f \n", e.get(maxp).getCityname(),al[maxp]);
       return e.get(maxp);
       }
    @Override
    public int compareTo(Traveller m) 
    { 
        return this.age - m.age; 
    } 
    
    
}