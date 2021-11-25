package hangmangame.extras;

import cs102.hangman.*;

/**
 * This class the LetterButtonControls class to implement it according to the hangman game.
 * @author Ahmet Faruk Ulutaþ
 * @version 13/04/2020
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {
   Hangman hangman;
   
   public HangmanLetterButtonControls( Hangman hangman) {
      this( hangman.getAllLetters(), 13, 2);
      this.hangman = hangman;
   }
   
   public HangmanLetterButtonControls( String letters, int rows, int columns) {
      super( letters, rows, columns);
   }
   @Override
   public void updateView( Hangman hangman) {
      setDisabled( hangman.getUsedLetters());
      if ( hangman.isGameOver()) {
         setEnabledAll( false);
      }
      if ( hangman.getUsedLetters().length() == 0) {
         setEnabledAll( true);
      }
   }
}