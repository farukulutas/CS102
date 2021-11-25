import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;
import shapes.*;

/**
 * Balloon Game Panel Class
 * @author Ahmet Faruk Ulutaþ
 * @version 05/04/2020
 */
public class BalloonsGamePanel extends JPanel {
   
   // properties
   static final int DEFAULT_WIDTH = 800;
   static final int DEFAULT_HEIGHT = 600;
   static final int MAX_ELAPSED_TIME = 250;
   static final int UPDATE_PERIOD = 100;
   static final int INIT_BALLOONS = 25;
   static final int MIN_BALLOONS = 15;
   ShapeContainer balloons;
   Timer timer;
   JLabel pointsLabel;
   int points;
   int passedTime;
   MouseListener pin;
   
   
   // constructors
   public BalloonsGamePanel() {
      this.add( this.pointsLabel = new JLabel() );
      this.setBackground( Color.YELLOW);
      this.setPreferredSize(new Dimension( DEFAULT_WIDTH, DEFAULT_HEIGHT));
      this.pin = new Pin();
      this.timer = new Timer( UPDATE_PERIOD, new GrowListener());
      this.initGame();
   }
   
   // methods
   
   /**
    * This method initilase the game with default values
    */
   private void initGame() {
      passedTime = 0;
      points = 0;
      pointsLabel.setText( "Points: " + points);
      balloons = new ShapeContainer();
      addRandomBalloons( INIT_BALLOONS, DEFAULT_WIDTH, DEFAULT_HEIGHT);
      addMouseListener( pin);
      timer.start();
   }
   
   /**
    * This method adds random ballons with specified number, width, height parameters
    * @param number Balloons's number
    * @param width Balloon's width
    * @param height Balloon's height
    */
   private void addRandomBalloons(int number, int width, int height) {
      for (int i = 0; i < number; ++i) {
         int x = (int)( Math.random() * (double)width);
         int y = (int)( Math.random() * (double)height);
         Balloon balloon = new Balloon( x, y);
         this.balloons.add( balloon); 
      }
   }
   
   /**
    * This method create Iterator object by using the shape container
    * @param g Graphics object
    */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Iterator<Shape> iterator = this.balloons.iterator();
      while ( iterator.hasNext()) {
         ( (Drawable)( (Object)iterator.next())).draw(g);
      }
   }
   
   /**
    * GrowListener Class which provides the grow balloons, remove and add balloons, check the timer and ask to
    * user for play again
    */
   private class GrowListener implements ActionListener {

      /**
       * This method create Iterator object by using the shape container
       * @param e Action event
       */
      @Override
      public void actionPerformed( ActionEvent e) {
         Iterator<Shape> iterator = BalloonsGamePanel.this.balloons.iterator();
         while ( iterator.hasNext()) {
            ( (Balloon)iterator.next()).grow();            
         }
         
         BalloonsGamePanel.this.balloons.removeAllSelected();
         
         if ( BalloonsGamePanel.this.balloons.size() < MIN_BALLOONS) {
            BalloonsGamePanel.this.addRandomBalloons( 1, BalloonsGamePanel.this.getWidth(),
                                                     BalloonsGamePanel.this.getHeight());
         }
         
         BalloonsGamePanel.this.repaint();
         ++BalloonsGamePanel.this.passedTime;
         
         if ( BalloonsGamePanel.this.passedTime >= MAX_ELAPSED_TIME) {
            BalloonsGamePanel.this.timer.stop();
            BalloonsGamePanel.this.removeMouseListener( BalloonsGamePanel.this.pin);
            int again = JOptionPane.showConfirmDialog( BalloonsGamePanel.this, "Play again?", "Game over", 0);
            
            if ( again == 0) {
               BalloonsGamePanel.this.initGame();
            }
         }
      }
   }
   
   /**
    * Pin Class which provides to pin a balloon and increase the point
    */
   private class Pin extends MouseAdapter {
      
      /**
       * This method listen the mouse event and select balloons and inrease the point
       * @param e Mouse event
       */
      @Override
      public void mousePressed( MouseEvent e) {
         int popCount = BalloonsGamePanel.this.balloons.selectAllAt( e.getX(), e.getY());
         if ( popCount >= 2) {
            BalloonsGamePanel.this.points += popCount;
            BalloonsGamePanel.this.pointsLabel.setText( "Points: " + BalloonsGamePanel.this.points);
         }
      }
   }
   
}