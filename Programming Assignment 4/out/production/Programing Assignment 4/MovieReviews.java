package anotherOne;//DELETE THIS
import java.util.*;
import java.io.*;



/**
 * 
 * SURAJ TYO MOST POSITIVE RA MOST NEGATIVE HALKA REDUNDANT KURA HARU CHAN .. YOU CAN COMBINE THEM AND MAKE THEM SMALLER 
 *
 */

public class MovieReviews {

	Map<String  , ReviewItem> amap;
	Set<String> bannedWords;
	
	public MovieReviews( String filename , int lines) {
		amap = new HashMap<>();
		initializeBannedWords();
		
		load( filename , lines);
	}
	
	
	
	public void load(String filename , int lines) {
		
		
		try {
			Scanner sc = new Scanner( new File( filename ) );
			sc.useDelimiter("\\W+");
			
			while (sc.hasNextLine() && lines > 0) {
				addToMap( sc.nextLine() );
				
				lines-= 1;
			}
		}
		
		catch (Exception ex) {
			System.out.print( "Error reading file");
		}		
		
	}
	
	
	
	private void addToMap( String line) {
		
		line = line.toLowerCase();
		String[] strArray = line.split(" ");
		int rating = Integer.parseInt(strArray[0]);
		
		for (int i = 1; i < strArray.length; i++) {//choosing 1 because 0th element is number
			String key = strArray[i];
			ReviewItem value= amap.get( key);
			
			if ( key.length() > 2 ) {
				if ( !bannedWords.contains(key) ) {//TOUGH ORDEAL!!
					if ( value!=null ) {
						
						value.updateRating( rating );
					}
					else {//first time occuring so adding fresh entry to our hashmap
						
						value = new ReviewItem( rating );
						amap.put( key, value);
					}
				}
				
			}
				
			
		}
			
	}
	
	
	private void initializeBannedWords() {
		bannedWords = new HashSet<String>();
		
		String[] X = {"i" , "you", "it", "he", "she", "we", "they", "a", "an", "the", "and", "or", "but" };
		
		for(String each: X) {
			bannedWords.add( each );
		}
		
	}
	
	
	
	public double reviewScore(String line) {
		line = line.toLowerCase();
		Scanner sc = new Scanner( line );
		sc.useDelimiter("\\W+");
		
		double totalPoints = 0.0;
		int instances = 0;
		
		while ( sc.hasNext() ) {
			String word = sc.next();
			if ( word.length() > 2) {
				if ( !bannedWords.contains( word)) {
					
					ReviewItem value= amap.get(word);
					if (value == null) {
						totalPoints += 2.0;
					}
					else {
						totalPoints += value.getAverage();
					}
					instances += 1;
				}
			}
		}
			
		if ( instances == 0) {
			return 0.0;
		}
		return totalPoints / ( instances);
		
	}
			
	
	
	
	public double wordScore(String word) {
		
		ReviewItem item = amap.get(word);
		if (item == null) {
			return 2.0;
		}
		else {
			return item.getAverage();
		}
		
	}
	
	
	public String mostPositive() {
		Set<String> mySet = amap.keySet();
		
		Iterator<String> myIterator = mySet.iterator();
		
		String most_word = "";
		double most_rating = 0.0;
		int most_timesOccured = 0;
		
		double curr_rating = 0.0;
		int curr_timesOccured = 0;
		
		double kappa = 0.0001;
		double rating_difference;
		
		while( myIterator.hasNext()) {
			String currWord = myIterator.next();
			ReviewItem item = amap.get(currWord);
			if (most_word == "") {
				most_word = currWord;
				most_rating = item.getAverage();
				most_timesOccured = item.getOccurances();
			}
			else {
				curr_rating = item.getAverage();
				curr_timesOccured = item.getOccurances();
				
				if ( curr_timesOccured > 1) {
					rating_difference = most_rating - curr_rating;
					
					if (Math.abs(rating_difference) <= kappa){//tieBreaker
						
						if ( curr_timesOccured > most_timesOccured) {
							most_word = currWord;
							most_rating = curr_rating;
							most_timesOccured = curr_timesOccured;
						}
	
					}
					
					else if (rating_difference < 0) {//currRating happened to be greater than current greatest
						most_word = currWord;
						most_rating = curr_rating;
						most_timesOccured = curr_timesOccured;
					}
					
					
					
				}
						
				
			}
			
		}
		
		return most_word;
		
	}
	
	
	
	
	public String mostNegative() {
		Set<String> mySet = amap.keySet();
		
		Iterator<String> myIterator = mySet.iterator();
		
		String least_word = "";
		double least_rating = 0.0;
		int most_timesOccured = 0;
		
		double curr_rating;
		int curr_timesOccured = 0;
		
		double kappa = 0.0001;
		double rating_difference = 0.0;
		
		while( myIterator.hasNext()) {
			String currWord = myIterator.next();
			ReviewItem item = amap.get(currWord);
			if (least_word == "") {
				least_word = currWord;
				least_rating = item.getAverage();
				most_timesOccured = item.getOccurances();
			}
			else {
				curr_rating = item.getAverage();
				curr_timesOccured = item.getOccurances();
				
				if ( curr_timesOccured > 1) {
					rating_difference = least_rating - curr_rating;
					
					if (Math.abs(rating_difference) <= kappa) {//tieBreaker
						
						if ( curr_timesOccured > most_timesOccured) {
							least_word = currWord;
							least_rating = curr_rating;
							most_timesOccured = curr_timesOccured;
						}
	
					}
					
					else if (rating_difference > 0) {//currRating happened to be smaller than current smallest
						least_word = currWord;
						least_rating = curr_rating;
						most_timesOccured = curr_timesOccured;
					}
					
					
					
				}
						
				
			}
			
			
			
		}
		
		return least_word;
		
		
	}
	
	
	
	
	
	
}
