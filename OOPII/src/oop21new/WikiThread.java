package oop21new;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.databind.ObjectMapper;

import wikipedia.MediaWiki;
public class WikiThread implements Runnable {
	
	private String appid;
	private String city;
	private String init;
	 private int cafe;
	 private int bars;
	 private int museums;
	 private int restaurants;
	 private String article;
	
	public WikiThread(String city, String init, String appid) {
		super();
		this.appid = appid;
		this.city = city;
		this.init = init;
	}
	
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

	@Override
	public void run() {
		
		ObjectMapper mapper = new ObjectMapper(); 
		 MediaWiki mediaWiki_obj;
		try {
			mediaWiki_obj = mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
		
			 article=mediaWiki_obj.getQuery().getPages().get(0).getExtract();
			// System.out.print(article);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());
		
		 
		 cafe = countCriterionfCity( article, "cafe");
		 bars = countCriterionfCity( article, "bar");
		 museums = countCriterionfCity( article, "museum");
		 restaurants = countCriterionfCity( article, "restaurant");
		 
		// System.out.printf("%d\n%d\n%d\n%d\nstop", cafe,bars,museums,restaurants);
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// TODO Auto-generated method stub
		
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

	public int getCafe() {
		return cafe;
	}

	public void setCafe(int cafe) {
		this.cafe = cafe;
	}

	public int getBars() {
		return bars;
	}

	public void setBars(int bars) {
		this.bars = bars;
	}

	public int getMuseums() {
		return museums;
	}

	public void setMuseums(int museums) {
		this.museums = museums;
	}

	public int getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(int restaurants) {
		this.restaurants = restaurants;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	
	

}
