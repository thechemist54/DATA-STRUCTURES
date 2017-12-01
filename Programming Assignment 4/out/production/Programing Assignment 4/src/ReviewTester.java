/**
	Sample main program to test methods of the MovieReviews class.
	Expected Output:
		Average score for 'epic': 4.0
		Average score for 'that': 1.5
		New Review:      A weak script that ends with a quick and boring finale
		Predicted score: 1.94
		New Review:      Outstanding performance !!
		Predicted score: 3.00
		Most positive word:      from
		Most negative word:      wild	
*/

public class ReviewTester
{
	public static void main(String[] args) 
	{
		MovieReviews reviews = new MovieReviews("movieReviews.txt", 6000);
		
		System.out.println("Average score for 'epic': " + reviews.wordScore("epic"));
		System.out.println("Average score for 'that': " + reviews.wordScore("that"));
		String review1 = "A weak script that ends with a quick and boring finale";
		System.out.println("New Review:      " + review1);
		System.out.printf ("Predicted score: %4.2f\n", reviews.reviewScore(review1));
		String review2 = "Outstanding performance !!";
		System.out.println("New Review:      " + review2);
		System.out.printf ("Predicted score: %4.2f\n", reviews.reviewScore(review2));
		System.out.println("Most positive word:      " + reviews.mostPositive());
		System.out.println("Most negative word:      " + reviews.mostNegative());
    }
}
