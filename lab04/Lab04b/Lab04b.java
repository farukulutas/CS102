import javax.swing.*;

/**
 * A simple baloon game!
 * @author Ahmet Faruk Uluta�
 * @version 05/04/2020
 */ 
public class Lab04b extends JFrame
{
   
   // properties
   JFrame frame;
   BalloonsGamePanel panel;
   
   // constructors
   public Lab04b() {
      frame = new JFrame( "Lab04b - Baloons");
      panel = new BalloonsGamePanel();
      
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      frame.setVisible( true);
      frame.add( panel);
      frame.pack();
   }
   
   // methods
   
   public static void main( String[] args)
   {  
      // program code
      Lab04b test = new Lab04b();
   }
   
}