
package oop21new;

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

/**
 *
 * @author elise
 */
public class City implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String cityname;
	private String country;
    private int museums;
    private int cafe;
    private int bars;
    private int restaurants;
    private String weather;
    private double lon;
    private double lan;
    private int mountains;
    private int beaches;
    private String article;
   // private WeatherThread t1;
   // private WikiThread t2;
    

    public City(String city, String country, String appid) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
    	//new code
   	 cityname = city;
   	 this.country=country;
    	 WeatherThread t1= new WeatherThread(cityname,this.country,appid);
    	 
    	// t1.w
    	 WikiThread t2 = new WikiThread(cityname,this.country,appid);
    	 t2.run();
    	t1.run();
    	
    	//t2.start();
    	

    	 
		 lan = t1.getLan();
		 lon = t1.getLon();
		 article=t2.getArticle();
		 //System.out.print(article);
		 //t2.start();
		 cafe = t2.getCafe();
		 bars = t2.getBars();
		 museums = t2.getMuseums();
		 restaurants = t2.getRestaurants();
		 
		 
		 
    	//new code
		 
		 
    	/*try { 
    	ObjectMapper mapper = new ObjectMapper(); 
		
		 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 
		 cityname = city;
		// System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		// System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 
		 lan = weather_obj.getCoord().getLat();
		 lon = weather_obj.getCoord().getLon();
		 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		// System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
		 article=mediaWiki_obj.getQuery().getPages().get(0).getExtract();
		 
		 cafe = countCriterionfCity( article, "cafe");
		 bars = countCriterionfCity( article, "bar");
		 museums = countCriterionfCity( article, "museum");
		 restaurants = countCriterionfCity( article, "restaurant");
		 this.country=country;
		
    	}catch(FileNotFoundException exception){
		     System.out.println("That country or city does NOT exist.Try again\n");
		     System.out.println("Programmer's note: we caught that exception but it causes another NullPointerException at the end of the program\n");
		 }
		 */
	    
	} 
       /* 
    public static int countCriterionfCity(String cityArticle, String criterion) {
    	cityArticle=cityArticle.toLowerCase();
    	int index = cityArticle.indexOf(criterion);
    	int count = 0;
    	while (index != -1) {
    	    count++;
    	    cityArticle = cityArticle.substring(index + 1);
    	    index = cityArticle.indexOf(criterion);
    	}
    	return count;
    }
    
    
	 public void RetrieveData(String city, String country, String appid) throws  IOException {
		 ObjectMapper mapper = new ObjectMapper(); 
		 OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		 cityname = city;
		// System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
		// System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
		 weather = weather_obj.getWeather().get(0).getMain();
		 
		 lan = weather_obj.getCoord().getLat();
		 lon = weather_obj.getCoord().getLon();
		 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		// System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
		 article=mediaWiki_obj.getQuery().getPages().get(0).getExtract();
	}
    */
	  	String appid ="c1fd00d8e51552b3e923b76ba43fad35";

    

    public String getArticle() {
		return article;
	}

    public void setArticle(String article) {
		this.article = article;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMuseums() {
        return museums;
    }

    public void setMuseums(int museums) {
        this.museums = museums;
    }
    
    public int getBars() {
		return bars;
	}

	public void setBars(int bars) {
		this.bars = bars;
	}

	public int getCafe() {
        return cafe;
    }

    public void setCafe(int cafe) {
        this.cafe = cafe;
    }

    
    public int getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(int restaurants) {
		this.restaurants = restaurants;
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

    public int getMountains() {
        return mountains;
    }

    public void setMountains(int mountains) {
        this.mountains = mountains;
    }

    public int getBeaches() {
        return beaches;
    }

    public void setBeaches(int beaches) {
        this.beaches = beaches;
    }
    
    
    
    public boolean equals(City obj, ArrayList<City> cities) {
   	// System.out.println("I am in");
   	 
   	 if(cities.size()==0) {
   		 return false;
   	 }else {
   	 for(int i=0; i<cities.size(); i++) {
   		 
   		 if(cities.get(i).getCityname().equals(obj.getCityname())) {
   			 return true; 
   		 }
   		 
   	 }}
   	 return false;
    }

    
   
}
