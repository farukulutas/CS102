package shapes;

/**
 * A simple Square class!
 * @author Ahmet Faruk Uluta?
 * @date 08/03/2020
 */
public class Square extends Rectangle
{
   // properties
   int side;
   boolean selected;
   
   // constructors
   public Square(int side) {
      super(side, side);
      this.side = side;
      x=0;
      y=0;
      selected = false;
   }
   
   public Square(int side, int x, int y) {
      super(side, side, x, y);
      this.side = side;
      this.x = x;
      this.y = y;
      selected = false;
   }
   
   // methods
   
   /**
    * @return area of square
    */
   @Override
   public double getArea() {
      return Math.pow(side, 2);
   }
   
   /**
    * @return side, positions and status of square
    */
   public String toString() {
      String select;
      if (selected) {
         select = "selected";
      } else
         select = "unselected";
      
      return "Square with a side :" + side + " (x,y = " + x + "," + y +
         ") " + select + '\n';
   }
   
   /**
    * @return selected true
    */
   public boolean getSelected() { return selected; }
   
   /**
    * @return alter selected with boolean set
    */
   public void setSelected(boolean set) { selected = set;}
   
   /**
    * @param x axis position
    * @param y axis position
    * @return check contains x true, check contains y true, if both of them
    * true return rectangle else falses and null ( CONTAINS X AND Y )
    */
   public Shape contains(int x, int y) {
      Square square;
      boolean checkX, checkY;
      double sideLength;
      
      square = new Square(side);
      sideLength = side / 2;
      
      if (Math.abs(this.x - x) <= sideLength)
         checkX = true;
      else
         checkX = false;
      
      if (Math.abs(this.y - y) <= sideLength)
         checkY = true;
      else
         checkY = false;
      
      if (checkX && checkY)
         return square;
      else
         return null;
   }
   
}