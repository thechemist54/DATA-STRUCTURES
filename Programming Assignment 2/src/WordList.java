import java.util.*;      //importing all the different class from IO and utility package
import java.io.*;

/**
 *Defining WordList class
 */
public class WordList
{
    /**
     *Two private instance variables for two different lists
     */
    private List<String> words;
    private List<String> word1;

    /**
     * Initializing non argument constructor
     */

    public WordList()
    {
        words = new ArrayList<>();
        word1 = new ArrayList<>();


    }

    /**
     * Initializes WordList class and adds strings from array to List
     * @param array The values to be stored in the arrayList
     */

    public WordList(String [] array)
    {
        words = new ArrayList<>();

        for(int i= 0;i<array.length;i++)  // loop for importing strings from array to array list
        {
            words.add(array[i]);
        }

        word1 = new ArrayList<>();

        for(int i= 0;i<array.length;i++)
        {
            word1.add(array[i]);
        }


    }

    /**
     * Adds to the list all of the words contained in the file.
     * @param filename The name of the file passed by the user.
     * @return Method returns true if file is opened successfully otherwise returns false.
     */

    public boolean readWords(String filename)
    {


        try     //looks for FileNotFoundException and catches it i.e. file handling
        {
            File infile = new File(filename);    //opening a file
            Scanner in = new Scanner(infile);    //reading from a file


            while(in.hasNext())                //using loop to check whether there are
                                              //strings in the loop and adding that string
            {                                // to the words array list
                String input = in.next();
                words.add(input);

            }

            in.close();   //file closing


            File ind = new File(filename);
            Scanner inp = new Scanner(ind).useDelimiter("[^A-Za-z0-9]+"); //delimiter for removing punctuations and symbols

            while(inp.hasNext())
            {
                String indp = inp.next();    //same as above but adding the string to the
                word1.add(indp);            //word1 array list
            }


            inp.close();

            return true;
        }
        catch (FileNotFoundException e)    //file handling
        {

            return false;
        }



    }

    /**
     * Method counts the total number of words stored in the list
     * @return Method returns the total number of words stored in the list
     */

    public int count()
    {
        int counter = 0;
        for (int i=0;i<words.size();i++)
        {
            counter+=1;
        }
        return counter;
    }

    /**
     * Method calculates number of times target is stored in the list
     * @param target determines what value has to be checked
     * @return Method returns the total number of times target was stored in the list.
     */

    public int count(String target)
    {
        int tcounter = 0;
        for(int i = 0; i<word1.size();i++)
        {
            /**
             * replaceAll removes any kind of punctuation from the strings in array
             */

            if(word1.get(i).toUpperCase().replaceAll("[^A-Za-z0-9]+","").equals(target.toUpperCase()))
            {
                tcounter+=1;
            }

        }
        return tcounter;
    }

    /**
     * Method replaces all the old words with the new ones.
     * @param old Represents the old word to be replaced.
     * @param neew Represents the new word to be stored in place of old words.
     * @param ignoreCase Represents whether the user considers to ignore case or not.
     * @return Method returns the number of replacements made as a result of replacing old by new words.
     */

    public int replace(String old,String neew, boolean ignoreCase)
    {
        int ocounter = 0;

        for(int i =0;i<words.size();i++)
        {
            if(ignoreCase == true)
            {
                if ((words.get(i)).toUpperCase().replaceAll("[^A-Za-z0-9]+","").equals(old.toUpperCase()))
                {
                    words.set(i, neew);
                    ocounter += 1;
                }
            }

            else if(ignoreCase == false)
            {
                if(words.get(i).equals(old))
                {
                    words.set(i,neew);
                    ocounter+=1;
                }
            }
        }

        for(int i =0;i<word1.size();i++)
        {
            if(ignoreCase == true)
            {
                if ((word1.get(i)).toUpperCase().replaceAll("[^A-Za-z0-9]+","").equals(old.toUpperCase()))
                {
                    word1.set(i, neew);

                }
            }

            else if(ignoreCase == false)
            {
                if(word1.get(i).equals(old))
                {
                    word1.set(i,neew);

                }
            }
        }

        return ocounter;
    }

    /**
     * Method displays the contents in the list.
     * @param wordsPerLine Represents the total number of words that should be in a line.
     * @return Method returns the total number lines displayed.
     */

    public int display(int wordsPerLine)
    {
        int lineCounter = 1;

        int i =0;
        int k = 0;   // different counter variables so that the loop runs properly
        int d = 0;

        while(i<words.size())
        {
            System.out.print(words.get(i)+" ");
            k+=1;
            if(k == wordsPerLine+d)    //changes to nextline, increments the words per line and line counter
            {
                System.out.println();
                d+=wordsPerLine;
                lineCounter+=1;
            }
            i+=1;


        }
        System.out.println();

        return lineCounter;
    }

    /**
     * Method returns the contents of the list in brackets.
     * @return A sequence of strings within the list.
     */

    public String toString()
    {
        String contents="";

        for(int i =0;i<words.size();i++)
        {
            contents = contents +" "+ words.get(i);

        }

        contents = contents.substring(1);

        return "["+contents+"]";
    }
}