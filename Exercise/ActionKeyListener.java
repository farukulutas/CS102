import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionKeyListener extends JButton implements KeyListener {
   // properties   
   Model m;
   
   // constructors
   public ActionKeyListener( Model m ) {
      this.m = m;
   }
   
   //methods
   @Override
   public void keyTyped( KeyEvent e) {   }
   
   @Override
   public void keyPressed( KeyEvent e) {
      if ( KeyEvent.getKeyText( e.getKeyCode() ) == "w" || KeyEvent.getKeyText( e.getKeyCode() ) == "a" 
             || KeyEvent.getKeyText( e.getKeyCode() ) == "s" || KeyEvent.getKeyText( e.getKeyCode() ) == "d" )
         m.play( KeyEvent.getKeyText( e.getKeyCode() ) );
   }
   
   @Override
   public void keyReleased( KeyEvent e) {   }
   
}