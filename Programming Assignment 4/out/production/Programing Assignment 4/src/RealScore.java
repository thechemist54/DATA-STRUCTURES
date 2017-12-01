/**
 * This is a helper class that helps determine the score of a word and count
 * the number of occurrence in the file.
 */

public class RealScore
{
    private double score;   //instance variables for determining the score and count
    private int count;

    /**
     * A non argument constructor to initialize the score and count.
     * @param inte The double used to first initialize score.
     */

    public RealScore(double inte)
    {
        this.score = inte;
        this.count = 1;
    }

    /**
     * This method updates the score by the argument and count by one.
     * @param inte The double by which the score has to be incremented.
     */

    public void update(double inte)
    {
        this.score+=inte;
        this.count+=1;
    }

    /**
     * This method gives the score of a particular word.
     * @return The score of the particular word.
     */

    public double getScore()
    {
        return (this.score/getCount());
    }

    /**
     * This method gives the count of the word.
     * @return The number of occurrences of the word.
     */

    public double getCount()
    {
        return this.count;
    }
}
