package hangmangame.extras;

import cs102.hangman.*;
import javax.swing.*;
import java.awt.event.*;

/* Class for controlling the text field
 * @author Ahmet Faruk Ulutaþ
 * @version 13/04/2020
 */
public class TextFieldControlPanel extends JPanel implements ActionListener {
   
   // properties
   private Hangman hangman;
   private JTextField textField;
   
   // constructors
   public TextFieldControlPanel( Hangman hangman) {
      super();
      this.hangman = hangman;
      textField = new JTextField( 20);
      
      this.add( textField);
      textField.addActionListener( this);
   }
   
   /* This method get the event and check every letter with tryThis in textField
    * @param event Event
    */
   public void actionPerformed( ActionEvent event) {
      String letters;
      
      // initilase letters with what entered textField
      letters = textField.getText();
      
      // check all letters with try this method
      for ( int i = 0; i < letters.length(); i++ ) {
         hangman.tryThis( letters.charAt( i) );
      }
      
      //  after processing all the letters it should clear the TextField
      textField.setText( "");
   }
   
}