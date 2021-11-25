import shapes.*;
import java.awt.Graphics;
import shapes.Drawable;
import java.awt.Color;

/**
 * Balloons Class
 * @author Ahmet Faruk Ulutaþ
 * @version 05/04/2020
 */
class Balloon extends Circle implements Drawable {
   
   // properties
   static final int DEFAULT_RADIUS = 25;
   static final int SIZE_INCREMENT = 5;
   static final int MAX_SIZE = 100;
   
   // constructors
   public Balloon( int x, int y) {
      super( DEFAULT_RADIUS);
      this.setLocation( x, y);
   }
   
   // methods
   
   /**
    * This method draw balloons via RGB color format, 256 BLACK ( Color.BLACK)
    * @param g Graphics' component
    */
   @Override
   public void draw( Graphics g) {
      g.setColor( Color.BLACK);
      
      int radius = this.getRadius();
      g.drawOval( this.getX() - radius, this.getY() - radius, radius * 2, radius * 2);
   }
   
   /**
    * This method increase the balloons radius
    * @return this.getRadius != 0 Return size of the radius while it is not zero
    */
   public boolean grow() {
      this.setRadius( this.getRadius() + SIZE_INCREMENT);
      
      if ( this.getRadius() > 100 ) {
         this.setRadius( 0);
         this.setSelected( true);
      }
      
      return this.getRadius() != 0;
   }
   
}