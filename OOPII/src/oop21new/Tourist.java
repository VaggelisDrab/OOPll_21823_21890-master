package oop21new;

import java.util.ArrayList;



public class Tourist extends Traveller {
	
	

	public Tourist(String name, int age, int cafe, int bar, int res, int beach, int mountain ,int mus, ArrayList<City> cities, boolean rain,City visit) {
		super(name, age, cafe, bar, res, beach, mountain , mus, cities, rain,visit);
		
		
	
	}
	
	


	
 
    
    /** Counts all words in the input String.
    @param str The input String.
    @return An integer, the number of all words.
    */	
    public static int countTotalWords(String str) {	
    	String s[]=str.split(" ");
    	return 	s.length;
    }
    
    /** Counts the number of times a criterion occurs in the city wikipedia article.
    @param cityArticle  The String of the retrieved wikipedia article.
    @param criterion The String of the criterion we are looking for.
    @return An integer, the number of times the criterion-string occurs in the wikipedia article.
    */	
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

    
    public double Similarity(City e) {
    	int numberofwords = countTotalWords(e.getArticle()); 
    	
  
    	int number =numberofwords ;
    	double p1 = (e.getBars() * bar);
    	double p2 = (e.getCafe() * cafe);
    	double p3 = (e.getMuseums() * mus);
    	double p4 = (e.getRestaurants()* res);
    	double p5 = (e.getBeaches() * beach);
    	double p6 = (e.getMountains() * mountain);
    	//System.out.printf("%f\n%f\n%f\n%f\n%f\n%f\n", p1, p2, p3, p4, p5, p6);
    	double sum = p1 + p2 + p3 + p4 + p5 + p6;
    	return (sum*100)/ number;
    
    
    
    }
    
    
    
}
