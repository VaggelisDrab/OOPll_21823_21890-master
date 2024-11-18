package oop21new;

import java.util.ArrayList;

public class Business extends Traveller {
	
	private double currentLat;
	private double currentLon;
	
	
	public Business(String name, int age, int cafe, int bar, int res, int beach, int mountain ,int mus, ArrayList<City> cities, boolean rain,City visit ,double currentLat, double currentLon) {
		super(name, age, cafe, bar, res, beach, mountain ,mus, cities, rain,visit);
		
		this.currentLat = currentLat;
		this.currentLon = currentLon;
	}



	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
			//hello
		}
	}
	
	

	
	public double Similarity(City e) {
		 
		double des = distance(e.getLan(), e.getLon(), currentLat, currentLon, "K"); 
		des = 1 - des/20037.5;
		
		return (des * 100)/20037.5;
		
		}
	
	
	
	
	
	
	
	


	public double getCurrentLat() {
		return currentLat;
	}


	public void setCurrentLat(double currentLat) {
		this.currentLat = currentLat;
	}


	public double getCurrentLon() {
		return currentLon;
	}


	public void setCurrentLon(double currentLon) {
		this.currentLon = currentLon;
	}
	
	
}
