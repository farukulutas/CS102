import java.io.*;
import java.util.Scanner;

/** 
 * Hangman Class
 * @author Ahmet Faruk Ulutaþ
 * @version 15.02.2020
 */

public class Hangman {
   
   // properties
   private int    maxAllowedIncorrectTries = 6;
   private StringBuffer secretWord;
   private StringBuffer allLetters;
   private StringBuffer usedLetters;
   private StringBuffer knownSoFar;
   private int          numberOfIncorrectTries;
   
   // constructor
   public Hangman()
   {
      allLetters = new StringBuffer ( "abcdefghijklmnnopqrstuvwxyz");
      maxAllowedIncorrectTries = 6;
      numberOfIncorrectTries = 0;
      usedLetters = new StringBuffer ( "");
      secretWord = new StringBuffer();
      secretWord = chooseSecretWord();
      int lengthOfWord;
      lengthOfWord = secretWord.length();
      knownSoFar = new StringBuffer( "");
      for(int n = 0 ; n < lengthOfWord ; n++)
      {
         knownSoFar.append("*");
      }
   }
   
   public String getSecretWord()
   {
      return secretWord.toString();
   }
   
   // methods
   
   //get methods
   public String getAllLetters() {
      return allLetters.toString();
   }
   
   public String getUsedLetters() {
      return usedLetters.toString();
   }
   
   public int getNumberOfIncorrectTries() {
      return numberOfIncorrectTries;
   }
   
   public int getMaxAllowedIncorrectTries() {
      return maxAllowedIncorrectTries;
   }
   
   public String getKnownSoFar() {
      return knownSoFar.toString();
   }
   
   public int tryThis( char letter) 
   {
      int occurrenceCount;
      
      // Checks for validity of the letter 
      if ( !( letter >= 'a' && letter <= 'z' ) && !( letter >= 'A' && letter <= 'Z') )
      {
         return -1;
      }
      
      // Check if the letter was known before
      for ( int index = 0; index < knownSoFar.length(); index++ )
      {
         if ( letter == knownSoFar.charAt( index) )
         {
            return -2;
         }
      }
      
      occurrenceCount = 0;
      
      // Check if the letter is in secretWord
      if ( secretWord.indexOf( Character.toString( letter)) != -1 )
      {
         // Loop through secretWord and find the index and mutate the knownSoFar StringBuffer object
         for ( int index = 0; index < secretWord.length(); index++ ) 
         {
            if ( letter == secretWord.charAt( index) )
            {
               occurrenceCount++;
               knownSoFar.setCharAt( index, letter);
            }
         }
         // Add the letter to usedLetter and return occurenceCount
         usedLetters.append( letter);
         return occurrenceCount;
      }
      // If the letter is not in secretWord increment numberOfIncorrectTries
      else 
      {
         usedLetters.append( letter);
         numberOfIncorrectTries++;
         // If game is over return -3
         if ( numberOfIncorrectTries == maxAllowedIncorrectTries )
         {
            return -3;
         }
         else
         {
            return occurrenceCount;
         }
      }
   }
   
   /**
    * If there are not any stars or if the  number of incorrect tries equals to 6, game  is over.
    * @return whether the game is over or not.
    */
   public boolean isGameOver() {
      
        if (numberOfIncorrectTries == 1) {
   System.out.println("Wrong guess, try again");
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println("___|___");
   System.out.println();
  }

  if (numberOfIncorrectTries == 2) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   | ");
   System.out.println("___|___");
  }
  
  if (numberOfIncorrectTries == 3) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\ " );
   System.out.println("   |        | o o |");
   System.out.println("   |         \\_  _/");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("   |");
   System.out.println("___|___");
  }
     
  if (numberOfIncorrectTries == 4) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\");
   System.out.println("   |        | o o |");
   System.out.println("   |        \\_  _/");
   System.out.println("   |           |");
   System.out.println("   |           |");
   System.out.println("   |");
   System.out.println("___|___");
  }
  
  if (numberOfIncorrectTries == 5) {
   System.out.println("Wrong guess, try again");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\");
   System.out.println("   |        | o o |");
   System.out.println("   |        \\_  _/");
   System.out.println("   |           |");
   System.out.println("   |           |");
   System.out.println("   |          / \\ ");
   System.out.println("___|___      /   \\");
  }
  
  if (numberOfIncorrectTries == 6) {
   System.out.println("GAME OVER!");
   System.out.println("   ____________");
   System.out.println("   |          _|_");
   System.out.println("   |         /   \\");
   System.out.println("   |        | o o |");
   System.out.println("   |        \\_  _/");
   System.out.println("   |          _|_");
   System.out.println("   |         / | \\");
   System.out.println("   |          / \\ ");
   System.out.println("___|___      /   \\");
   System.out.println("GAME OVER!");
  }
  
      return ((maxAllowedIncorrectTries == numberOfIncorrectTries) || (knownSoFar.indexOf("*") == -1) ); 
   }
   
   /**
    * If number  of incorrect answers reaches 6 and there are stars left, player lost.
    * @return whether player lost or not.
    * */
   public boolean hasLost() {
      return ((knownSoFar.indexOf("*") != -1) && (maxAllowedIncorrectTries == numberOfIncorrectTries));
   }
   
   /**
    * Returns a word chosen at random from a fixed array of words (defined in program code).
    * If the array is empty or only has null's then it will use a built-in list.
    * @param wordList An array to choose the secretWord from.
    * @return A randomly selected StringBuffer form the array.
    */
   public StringBuffer chooseSecretWord ( String[] wordList ) {
      // constants 
      
      // variables 
      int random;
      
      // program code
      random = (int) ( Math.random() * wordList.length );
      // If the wordList[random] is null then choose again.
      while ( wordList[random] == null ) {
         random = (int) ( Math.random() * wordList.length );
      }
      
      return new StringBuffer( wordList[random] );
   }
      
   public StringBuffer chooseSecretWord ( String directory ) throws FileNotFoundException {
      // constants
      
      // variables
      int linesInFile;
      int random;
      File file;
      Scanner scan;
      
      // program code
      file = new File( directory);
      scan = new Scanner( file);
      secretWord = new StringBuffer();
      linesInFile=0;
      while( scan.hasNext() ) {
         linesInFile = linesInFile + 1;
         scan.next();
      }
      scan.close();
      // Choose random line and reset Scanner so we start from the beginning
      random = (int) ( Math.random() * linesInFile );
      scan = new Scanner( file);
      
      for ( int i = random; i > 0; i-- ) {
         scan.next();
      }
      scan.close();
      return new StringBuffer( );
      
   }
   
   /**
    * Returns a word chosen at random from a fixed array of words (defined in method code).
    * Also used when the other methods can NOT choose a secretWord.
    * @return A randomly selected StringBuffer form the array.
    */
   public StringBuffer chooseSecretWord() {
      // constants 
      final String[] WORDLIST = { "emphasis" , "scheme" , "layer" , "volume" , "document" , "registered" , "coresector" , "available" , "financial" , "process" };
      
      // variables 
      int random;
      
      // program code
      random = (int) ( Math.random() * WORDLIST.length );
      return new StringBuffer( WORDLIST[random] );
   }
   
}