package hangmangame.extras;

import cs102.hangman.*;
import java.awt.*;
import javax.swing.*;

/**
 * Collection of UI components to form a complete Hangman game. 
 * View components implement IHangmanView, so they can automatically update
 * whenever the hangmanModel associated with changes, changes.
 * Other components are hangman controllers that update the model.
 * @author david
 */
public class HangmanGUIPanel extends JPanel {
   
   private HangmanModel hm;
   private TextFieldControlPanel textField;
   private NewGameButtonControl newGameButton;
   private LabelsHangmanView labels;
   private GallowsHangmanView hangmanView;
   private HangmanLetterButtonControls keyboard;
   private LetterButtonListener listener;
   
   public HangmanGUIPanel( HangmanModel hm) {
      this.hm = hm;
      setPreferredSize( new Dimension( 500, 500) );
      setLayout( new BorderLayout() );
      setBackground( Color.YELLOW);
      
      // add controls and views here...
      
      // add textFieldControlPanel and set it north of the layout
      this.textField = new TextFieldControlPanel( hm);
      add( textField, BorderLayout.NORTH);
      
      this.newGameButton = new NewGameButtonControl( hm);
      hm.addView( newGameButton);
      add( newGameButton, BorderLayout.SOUTH);
      
      this.labels = new LabelsHangmanView();
      hm.addView( labels);
      add( labels, BorderLayout.WEST);
      
      this.hangmanView = new GallowsHangmanView( hm);
      hm.addView( hangmanView);
      add( hangmanView, BorderLayout.CENTER);
      
      this.keyboard = new HangmanLetterButtonControls( hm);
      this.listener = new LetterButtonListener( hm);
      hm.addView( keyboard);
      keyboard.addActionListener( listener);
      add( keyboard, BorderLayout.EAST);
   }
   
}