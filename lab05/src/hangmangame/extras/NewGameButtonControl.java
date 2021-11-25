package hangmangame.extras;

import cs102.hangman.*;
import java.awt.event.*;
import javax.swing.*;

/* Class for creating and controlling new game button
 * @author Ahmet Faruk Ulutaþ
 * @version 13/04/2020
 */
public class NewGameButtonControl extends JButton implements ActionListener, IHangmanView {
   private Hangman hangman;
   
   public NewGameButtonControl( Hangman hangman) {
      super( "New Game");
      this.hangman = hangman;
      this.addActionListener( this);
      this.setEnabled( false);
   }
   
   /* This method get the event and create a new game
    * @param event Event
    */
   public void actionPerformed( ActionEvent event) {
      hangman.initNewGame();
      this.setEnabled( false);
   }
   
   /* This method get the event and create a new  game if game is ended
    * @param event Event
    */
   public void updateView( Hangman hangman) {
      if ( hangman.isGameOver() ) {
         this.setEnabled( true);
      }
   }
   
}