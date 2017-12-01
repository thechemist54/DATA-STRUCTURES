package anotherOne;

public class ReviewItem {
	
	private int rating;
	private int occurances;
	
	public ReviewItem( int r) {
		
		this.rating = r;
		this.occurances = 1;
	}
	
	
	
	public void updateRating ( int r) {
		this.rating += r;
		this.occurances += 1;
	}
	
	
	public double getAverage() {
		return ( this.rating /(this.occurances * 1.0) );
	}
	
	
	public int getOccurances() {
		return this.occurances;
	}
}
