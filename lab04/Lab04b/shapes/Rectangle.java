package shapes;

/**
 * A simple Rectangle class!
 * @author Ahmet Faruk Uluta?
 * @date 08/03/2020
 */
public class Rectangle extends Shape
{
   // properties
   int sides, width, height;
   boolean selected;
   
   // constructors
   public Rectangle( int width, int height) {
      super();
      this.width = width;
      this.height = height;
      selected = false;
   }
   
   public Rectangle( int width, int height, int x, int y) {
      super();
      this.width = width;
      this.height = height;
      this.x = x;
      this.y = y;
      selected = false;
   }
   
   // methods
   
    /**
    * @return area of rectangle
    */
   @Override
   public double getArea() {
      return width * height;
   }
   
   /**
    * @return sides, position and status of rectangle
    */
   public String toString() {
      String select;
      
      if (selected) {
         select = "selected";
      } else
         select = "unselected";
      return "Rectangle with heigth :" + height + " and width :" + width 
         + " (x,y = " + x + "," + y + ") " + select + '\n';
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
    * @return selected true
    */
   public boolean getSelected() {
      return selected;
   }
   
   /**
    * @param change status of selected true or false
    */
   public void setSelected(boolean set) {
      selected = set;
   }
   
   /**
    * @param x axis position
    * @param y axis position
    * @return check contains x true, check contains y true, if both of them
    * true return rectangle else falses and null
    */
   public Shape contains(int x, int y) {
      
      // properties
      Rectangle rectangle;
      double widthLength;
      double heightLength;
      boolean checkX, checkY;
      
      // initialise
      rectangle = new Rectangle( height, width);
      widthLength = width / 2;
      heightLength = height / 2;
      
      // check the positions are in the rectangle and return rectangle or null
      if (Math.abs(this.x - x) <= widthLength)
         checkX = true;
      else
         checkX = false;
      
      if (Math.abs(this.y - y) <= heightLength)
         checkY = true;
      else
         checkY = false;
      
      if (checkX && checkY)
         return rectangle;
      else
         return null;
   }
   
}