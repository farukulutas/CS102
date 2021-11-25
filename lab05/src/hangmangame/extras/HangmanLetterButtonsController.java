package hangmangame.extras;

import java.awt.event.*;
import cs102.hangman.*;
import javax.swing.*;

/* Class for creating and controlling new game button
 * @author Ahmet Faruk Ulutaþ
 * @version 13/04/2020
 */
public class HangmanLetterButtonsController implements ActionListener {
   private Hangman hangman;
   
   public HangmanLetterButtonsController(Hangman hangman) {
      this.hangman = hangman;
   }
   
   public void actionPerformed(ActionEvent event) {
      JButton button = ( JButton) event.getSource(); 
      char ch = button.getText().charAt( 0);
      hangman.tryThis( ch); 
      button.setEnabled( false);
   }
   
}