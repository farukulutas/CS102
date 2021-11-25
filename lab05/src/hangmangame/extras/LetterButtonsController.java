package hangmangame.extras;

import java.awt.event.*;
import cs102.hangman.*;
import javax.swing.*;

/* Class for creating and controlling letter button
 * @author Ahmet Faruk Ulutaþ
 * @version 13/04/2020
 */
public class LetterButtonsController implements ActionListener {
   private Hangman hangman;
   
   public LetterButtonsController(Hangman hangman) {
      this.hangman = hangman;
   }
   
   /* This method get the event and check every letter with tryThis in textField
    * @param event Event
    */
   public void actionPerformed( ActionEvent event) {
      JButton button = ( JButton) event.getSource(); 
      char ch = button.getText().charAt( 0);
      hangman.tryThis( ch); 
      button.setEnabled( false);  
   }
   
}