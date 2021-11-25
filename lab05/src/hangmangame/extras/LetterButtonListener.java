package hangmangame.extras;

import javax.swing.*;
import java.awt.event.*;
import cs102.hangman.*;

/* Class for creating and controlling new game button
 * @author Ahmet Faruk Ulutaþ
 * @version 13/04/2020
 */
public class LetterButtonListener implements ActionListener {
   Hangman hangman;
   LetterButtonControls letterButtonControls;
   
   public LetterButtonListener( Hangman hangman) {
      this.hangman = hangman;
   }
   
   /* This method get the event and check every letter by using tryThis method
    * @param e Event
    */
   public void actionPerformed(ActionEvent e) {
      ( ( JButton)e.getSource()).setEnabled( false);
      hangman.tryThis( ( ( JButton)e.getSource()).getActionCommand().charAt( 0));
   }
   
}