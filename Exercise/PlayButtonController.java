import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonController extends JButton {
   // properties
   Model m;
   
   // constructors
   public PlayButtonController( Model m) {
      this.m = m;  
   }
   
   public void actionPerformed( ActionEvent e) {
      m.play( e);
   }
   
}