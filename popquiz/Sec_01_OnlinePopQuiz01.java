import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A simple Java class!
 */
public class Sec_01_OnlinePopQuiz01
{
   
   // properties
   double radius, circumference;
   JFrame frame;
   JPanel panel, panel2;
   JLabel labelRadius, labelCircumference;
   JTextField textForRadius, textForCircumference;
   
   // constructors
   public Sec_01_OnlinePopQuiz01() {
      radius = 0.0;
      circumference = 0.0;
      
      frame = new JFrame( "Circle Computer");
      frame.setBounds(400, 100, 400, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      
      panel = new JPanel();
      
      GridLayout layout = new GridLayout( 2, 2);
      panel.setLayout( layout);
      
      labelRadius = new JLabel("Radius: ");
      labelCircumference = new JLabel("Circumference: ");
      
      textForRadius = new JTextField(10);
      textForCircumference = new JTextField(10);
      
      panel.add( labelRadius);
      panel.add( textForRadius);
      
      panel.add( labelCircumference);
      panel.add( textForCircumference);
      
      frame.getContentPane().add( panel);
      frame.pack();
      
      textForRadius.addKeyListener( new DirectionListener() );
      textForCircumference.addKeyListener( new DirectionListener() );
      
      Font font = frame.getFont();

        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
   }
   
   private class DirectionListener extends KeyAdapter
   {
      public void keyPressed( KeyEvent event )
      {
         int key = event.getKeyCode();
         double radius, circumfrence;
         
         if( key == KeyEvent.VK_ENTER )
         {
            if( event.getSource() == textForRadius )
            {
               radius = Double.parseDouble( textForRadius.getText() );
               textForCircumference.setText( "" + radius * Math.PI * 2 );
            }
            else if( event.getSource() == textForCircumference)
            {
               circumfrence = Double.parseDouble( textForCircumference.getText() );
               textForRadius.setText( "" + circumfrence / (Math.PI * 2) );
            }
         }
      }
   }
   
   public static void main(String args[]) {
      
      // Create an object
      new Sec_01_OnlinePopQuiz01();
   }
   
}