import java.util.Scanner;

/**
 * This is the main method class for hangman game.
 * @author Ahmet Faruk Uluta?
 * @version 15/02/2020
 */ 
public class HangManGame
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables
      boolean play;
      char input;
      int output;
      Hangman hang;
      int won;
      int lost;

      // program code
      System.out.println( "Start...Stop?");
      play = true;
      won = 0;
      lost = 0;
      while ( play)
      {
        System.out.println("Welcome to Hangman game");
        hang = new Hangman();
        while(!hang.isGameOver())
        {
          //Current State
          System.out.println(hang.getKnownSoFar());
          System.out.print("Number of remaining tries ");
          for(int i = hang.getMaxAllowedIncorrectTries() - hang.getNumberOfIncorrectTries(); i > 0; i--)
          {
            System.out.print(" *");
          }
          System.out.println();
          if (!( hang.getUsedLetters().equals("") ))
          {
          System.out.println("These are the letters you used : " + hang.getUsedLetters()); 
          }
          input = scan.next().charAt(0);
          while(!Character.isLetter(input))
          {
            System.out.println("Please enter a letter ");
            input = scan.next().charAt(0);
          }
          output = hang.tryThis(input);
          if ( output > 0)
            System.out.println( "The word contains the letter " + input + " " + output + " times.");  
          else if ( output == 0)
            System.out.println( "The word doesn`t contain the letter " + input);
          else if ( output == -1)
            System.out.println( "Invalid letter");
          else if ( output == -2)
            System.out.println( "Previously tried letter");
        }
        if(hang.hasLost())
        {
          System.out.println("You lost the game. The secret word was " + hang.getSecretWord());
          lost++;
        }else
        {
          System.out.println("Congratulations, you guessed the secret word. The secret word was " + hang.getSecretWord());
          won++;
        }
        System.out.println("Games won: " + won);
        System.out.println("Games lost: " + lost);
        System.out.println("Do you want to play again? Enter n if you don't");
        if(scan.next().charAt(0) == 'n')
        {
          play = false;
        }
        System.out.println("Goodbye");
           
      }
      scan.close();
      System.out.println( "End.");
   }
   
   

}