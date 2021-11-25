package shapes;

/**
 * A simple Circle class!
 * @author Ahmet Faruk Ulutaþ
 * @date 08/03/2020
 */
public class Circle extends Shape implements Selectable
{
   // properties
   int radius;
   boolean selected;
   
   // constructors
   public Circle( int radius) {
      super();
      this.radius = radius;
      x = 0;
      y = 0;
      selected = false;
   }
   
   public Circle( int radius, int x, int y) {
      super();
      this.radius = radius;
      this.x = x;
      this.y = y;
      selected = false;
   }
   
   // methods
   
   /**
    * @return area of circle
    */
   @Override
   public double getArea() {
      return Math.PI * Math.pow(radius, 2);
   }
   
   /**
    * @return radius of circle
    */
   public int getRadius() {
      return this.radius;
   }
   
   /**
    * This method change the size of radius
    * @param radius New size of radius
    */
   public void setRadius( int radius) {
      this.radius = radius;
   }
   
   /**
    * @return radius, position and status of circle
    */
   public String toString() {
      String select;
      if (selected) {
         select = "selected";
      } else
         select = "unselected";
      
      return "Circle with radius :" + radius + " (x,y = " + x + "," + y + ") " + select + '\n';
   }
   
   /**
    * @param x axis position
    * @param y axis position
    */
   @Override
   public void setLocation(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   /**
    * @return selected (true)
    */
   public boolean getSelected() {
      return selected;
   }
   
   /**
    * @param set selected
    */
   public void setSelected(boolean set) {
      selected = set;
      
   }
   
   /**
    * @param x position x
    * @param y position y
    * @return this, null If contains return shape or null
    * true return circle else falses and null
    */
   public Shape contains(int x, int y) {
      final int deltaX2 = (x - this.getX()) * (x - this.getX());
      final int deltaY2 = (y - this.getY()) * (y - this.getY());
      if (deltaX2 + deltaY2 <= this.radius * this.radius) {
         return this;
      }
      return null;
   }
   
}