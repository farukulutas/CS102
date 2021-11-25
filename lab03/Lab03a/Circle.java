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
    * @return check contains x true, check contains y true, if both of them
    * true return circle else falses and null
    */
   public Shape contains(int x, int y) {
      Circle circle;
      boolean checkX, checkY;
      
      circle = new Circle( radius);
      
      if (Math.abs(this.x - x) <= radius)
         checkX = true;
      else
         checkX = false;
      
      if (Math.abs(this.y - y) <= radius)
         checkY = true;
      else
         checkY = false;
      
      if (checkX && checkY)
         return circle;
      else
         return null;
   }
   
}