import java.io.FileNotFoundException;

/**
    * This program can be used to test the WordList class methods.
  	 *
	 * @author Dr.C.
    */
   public class WordListTest
   {
      public static void main(String[] args)
      {    
      	WordList words = new WordList();
			System.out.println(words.count() + " words in the list");
         System.out.println("beatles appears " + words.count("beatles") + " times\n");
			
		 String [] anthem = {"Oh", "say", "can!;,", "you", "see" };
         words =	new WordList(anthem);	
         System.out.println(words.count() + " words in the list");
         System.out.println("can appears " + words.count("can") + " time(s)");
         System.out.println("can replaced " + words.replace("can", "do", true) + " time(s)");
         System.out.println("beatles appears " + words.count("beatles") + " times\n");            
         System.out.println("WORDS:");
         int lines = words.display(3);
         System.out.println("\nTotal # of lines: " + lines);
		 System.out.println("\nCONTENTS: " + words);
         
         words =	new WordList();	
         words.readWords("beatlesbio.txt");
         System.out.println("\n" + words.count() + " words in the list");
         System.out.println("rock appears " + words.count("rock") + " time(s)");
         System.out.println("rock replaced " + words.replace("rock", "rock-and-roll", true) + " time(s)");
         System.out.println("beatles appears " + words.count("beatles") + " times\n");
		   
         System.out.println("WORDS:");
         lines = words.display(10);
         System.out.println("\nTotal # of lines: " + lines);
      }
   }