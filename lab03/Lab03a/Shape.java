/**
 * A simple Shape class!
 * @author Ahmet Faruk Ulutaþ
 * @date 08/03/2020
 */
public abstract class Shape implements Locatable
{
   // properties
   int sides, width, height, x, y;
   
   // constructors
   public Shape() {
      x = 0;
      y = 0;
   }
   
   // methods
   
   /**
    * abstract get area
    */
   public abstract double getArea();
   
   /**
    * @return x axis
    */
   public int getX() {
      return x;
   }
   
   /**
    * @return y axis
    */
   public int getY() {
      return y;
   }
   
   /**
    * set a new location to x and y
    * @param x axis position
    * @param y axis position
    */
   public void setLocation( int x, int y) {
      this.x = x;
      this.y = y;
   }
   
}