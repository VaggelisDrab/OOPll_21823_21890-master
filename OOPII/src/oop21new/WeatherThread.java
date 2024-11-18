package oop21new;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import weather.OpenWeatherMap;
import wikipedia.MediaWiki;

import com.fasterxml.jackson.databind.ObjectMapper;

import weather.OpenWeatherMap;

public class WeatherThread implements Runnable  {
	
	private String appid;
	private String city;
	private String init;
    private String weather;
    private double lon;
    private double lan;
    
    
    
	public WeatherThread(String city, String init, String appid) {
		super();
		this.appid = appid;
		this.city = city;
		this.init = init;
	}



	@Override
	public void run()  {
		//boolean f = false;
		ObjectMapper mapper = new ObjectMapper(); 
		
		 OpenWeatherMap weather_obj;
		try {
			
			weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+init+"&APPID="+appid+""), OpenWeatherMap.class);
			 lan = weather_obj.getCoord().getLat();
			 lon = weather_obj.getCoord().getLon();
			// f = true;
			 Thread.sleep(100);
			 return;
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
		//	 TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// cityname = city;
		// System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		// System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 

		
		
	}



	public String getWeather() {
		return weather;
	}



	public void setWeather(String weather) {
		this.weather = weather;
	}



	public double getLon() {
		return lon;
	}



	public void setLon(double lon) {
		this.lon = lon;
	}



	public double getLan() {
		return lan;
	}



	public void setLan(double lan) {
		this.lan = lan;
	}



	public String getAppid() {
		return appid;
	}



	public void setAppid(String appid) {
		this.appid = appid;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getInit() {
		return init;
	}



	public void setInit(String init) {
		this.init = init;
	}
	
	
	
	

}
