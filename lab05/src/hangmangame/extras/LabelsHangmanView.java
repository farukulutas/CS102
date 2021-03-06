package hangmangame.extras;

import javax.swing.*;
import java.awt.*;
import cs102.hangman.*;

/* Class for creating and controlling new game button
 * @author Ahmet Faruk Uluta?
 * @version 13/04/2020
 */
public class LabelsHangmanView extends JPanel implements IHangmanView {
   JLabel noOfTries;
   JLabel lettersUsed;
   JLabel knownSoFar;
   
   //constructor
   public LabelsHangmanView() {
      super();
      
      // intializing properties
      noOfTries = new JLabel("");
      lettersUsed = new JLabel("");
      knownSoFar = new JLabel("");
      
      //  setting layout
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      this.add(knownSoFar);
      this.add(noOfTries);
      this.add(lettersUsed);
      this.setBackground(Color.green);
      this.setPreferredSize( new Dimension( 150,200));
   }
   
   //implementing IHangmanView
   @Override
   public void updateView(Hangman hangman) {
      if ( !hangman.isGameOver() ) {
         knownSoFar.setText(hangman.getKnownSoFar()); 
         noOfTries.setText("No of tries: " + hangman.getNumOfIncorrectTries());
         lettersUsed.setText( hangman.getUsedLetters());
         repaint();
      }
      else {
         if ( hangman.hasLost() ) { 
            knownSoFar.setText("You lost!");
            noOfTries.setText("Try again.");
            lettersUsed.setText( hangman.getUsedLetters());
         } 
         else {
            this.knownSoFar.setText("Congrats, you won!");
            noOfTries.setText("No of Tries: " + hangman.getNumOfIncorrectTries());
            lettersUsed.setText( hangman.getUsedLetters());
         }
      }
   }
   
}