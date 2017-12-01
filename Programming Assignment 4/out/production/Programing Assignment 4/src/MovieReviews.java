import java.util.*;    //importing the utility and IO packages
import java.io.*;

/**
 * Defining the main class. This class stores every word in a file in a map and
 * calculates what each word is trying to mean. What the wordScore is and what
 * type the sentence means (i.e good or bad review). This program is basically a
 * small scale interpretation of machine learning.
 */

public class MovieReviews
{


    private Map<String, RealScore> mapp ;     //Declaring two maps with String as key and the class Real Score as item
    private Map<String, RealScore> mapp1 ;
    Set<String> non_req;

    /**
     * This is a argument constructor which initializes the maps and and adds the respective keys
     * ,word score and counter of words associated with the keys.
     * @param filename The method reads from this file provided by the user.
     * @param numberOfLines The number of lines to be read by the user.
     */

    public MovieReviews(String filename, int numberOfLines)
    {
        mapp = new HashMap<>();
        mapp1 = new HashMap<>();

        non_req = new HashSet<>();   //defines a set and adds elements that are not required in the map to
                                                 //the set

        non_req.add("i");
        non_req.add("you");
        non_req.add("it");
        non_req.add("he");
        non_req.add("she");
        non_req.add("we");
        non_req.add("they");
        non_req.add("a");
        non_req.add("an");
        non_req.add("the");
        non_req.add("and");
        non_req.add("or");
        non_req.add("but");



       int count = 0;

       try     //handles any kind of exception, in this case FileNotFoundException.
       {
           Scanner in = new Scanner(new File(filename));   //Scan file and remove any kind of non alphanumeric characters.
           in.useDelimiter("[^A-Za-z]+");
           in.useDelimiter("\\s+");


           while(in.hasNextLine() && count<numberOfLines)   //The statements below checks whether the file has statements and
                                                            //splits each line and adds each word to array which is finally used
                                                            //to calculate word score and associate the keys and wordscore in the list
           {
                count+=1;

                String line = in.nextLine().toLowerCase();
                String[] array = line.split(" ");
                Double rate = Double.parseDouble(array[0]);


                for(int i =1;i<array.length;i++)
                {
                    String word = array[i];
                    RealScore d = mapp1.get(word);

                    if(word.length()>2)
                    {
                        if(!(non_req.contains(word)))
                        {
                            if(d!=null)
                            {
                                d.update(rate);

                            }

                            else
                            {
                                d = new RealScore(rate);
                                mapp1.put(word, d);
                                mapp.put(word,d);
                            }
                        }
                    }

                }


           }
           in.close();    //file close


       }
       catch(Exception e)
       {

       }
    }

    /**
     * This method claculates the score of the word passed on by the user.
     * @param word The word whose score needs to be calculated.
     * @return The score associated with the word.
     */

    public double wordScore(String word)
    {


        double score;

        if(mapp1.get(word)!=null)
        {

            score = mapp1.get(word).getScore();
        }

        else
        {
            score = 2.0;
        }


        return score;
    }

    /**
     * The method calculates the score of a sentence based on the word score
     * of the words in the sentence.
     * @param review The sentence whose score has to be calculated.
     * @return The score of the line passed on as the argument.
     */

    public double reviewScore(String review)
    {
        /**
         * Here the sentence is split and all the words in the sentence is added to an
         * array after which the score of the particular word is calculated and
         * finally it is divided by the size of the sentence to get the
         * average score.
         */

        double number = 0;

        List<String> sentence = new ArrayList<>();
        review = review.toLowerCase();
        String[] word = review.split("\\s+");
        for(int i =0;i<word.length;i++)
        {
            word[i]=word[i].replaceAll("[^A-Za-z]+","");
        }

        for(int i=0;i<word.length;i++)
        {
            if(word[i].length()>2)
            {
                sentence.add(word[i]);
            }

        }

        sentence.removeAll(non_req);

        for(int i =0;i<sentence.size();i++)
        {
            number+=wordScore(sentence.get(i));


        }






        return (number/sentence.size());


    }

    /**
     * This method calculates the most positive word in the collection.
     * @return The string with the highest word score in the collection.
     */

    public String mostPositive()
    {
        double score = 0;
        String high = "";

        Iterator iter = mapp1.keySet().iterator();  //iterator for iterating through the keys in map

        while(iter.hasNext())
        {
            String item = (String) iter.next();
            if(mapp.get(item).getCount()>=2)
            {
                if (mapp1.get(item).getScore() > score)
                {
                    score = mapp1.get(item).getScore();         //calculates the highest score word
                    high = item;
                }

                else if (mapp1.get(item).getScore()==score)
                {
                    score = mapp1.get(item).getScore();
                    if(mapp.get(item).getCount()>mapp.get(high).getCount())  //if scores are equal checks which
                    {                                                        //word has the highest count in the collection.
                        high = item;
                    }
                }
            }
        }
        return high;

    }

    /**
     * This method calculates the most negative word in the collection.
     * @return The string with the worst word score in the collection.
     */

    public String mostNegative()
    {

        double score = 5;
        String low = "";

        Iterator iter = mapp1.keySet().iterator();    //iterator to iterate through the key set.

        while(iter.hasNext())
        {
            String item = (String) iter.next();
            if(mapp.get(item).getCount()>=2)
            {
                if (mapp1.get(item).getScore() < score)       //calculates the lowest word score.
                {
                    score = mapp1.get(item).getScore();
                    low = item;
                }

                else if (mapp1.get(item).getScore()==score)    //if scores are equal,
                                                               //calculates the highest count in the collection.
                {
                    score = mapp1.get(item).getScore();
                    if(mapp.get(item).getCount()>mapp.get(low).getCount())
                    {
                        low = item;
                    }
                }
            }
        }
        return low;


    }


}
