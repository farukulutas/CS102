import java.util.ArrayList;

/**
 * to hold a set of shapes
 * @author Ahmet Faruk Uluta?
 * @date 08/03/2020
 */
public class ShapeContainer
{
   // properties
   ArrayList<Selectable> shapeContainer;
   
   // constructors
   public ShapeContainer() {
      shapeContainer = new ArrayList<Selectable>();
   }
   
   // methods
   
   /**
    * @param s
    * @return x axis
    */
   public void add( Selectable s) {
      shapeContainer.add( s);
   }
   
   /**
    * @return sum of shape containers' area
    */
   public double getArea() {
      int sum;
      
      sum = 0;
      
      for( int i = 0; i < shapeContainer.size(); i++ ) {
         
         sum += ((Shape)shapeContainer.get(i)).getArea();
      }
      
      return sum;
   }
   
   /**
    * @return result of strings
    */
   public String toString() {
      String result;
      
      result = "Shape container includes : " + '\n';
      
      for( int i = 0; i < shapeContainer.size(); i++ ) {
         result += shapeContainer.get(i).toString();
      }
      
      return result;
   }
   
   /**
    * selected check is true if the shape exists, false if not
    */
   public void removeAllSelected(){
      boolean selectedCheck;  // checks if no selected shape
      
      selectedCheck =false;
      
      for (int i = 0; i < shapeContainer.size(); i++) {
         
         if ((shapeContainer.get(i)).getSelected()) {
            System.out.println("Removed shape :" + shapeContainer.get(i));
            shapeContainer.remove(i);
            selectedCheck = true;
            // boolean turns true if any selected shape exists
         } else if (!selectedCheck) {
            System.out.println("No such shape found!"+'\n');
         }
      }
      
   }
   
   /**
    * @param x axis position
    * @param y axis position
    */
   public void findFirstContains(int x,int y){
      boolean containCheck; // checks the first shape to contain given x,y
      
      containCheck = true;
      
      for (int i = 0; i < shapeContainer.size() && containCheck; i++) {
         if (shapeContainer.get(i).contains(x, y) != null) {
            shapeContainer.get(i).setSelected(true);
            System.out.println("Shape is found :" + shapeContainer.get(i));
            containCheck = false;
            // boolean turns false when first shape is found
         } else if (i == shapeContainer.size() - 1
                       && shapeContainer.get(i).contains(x, y) == null) {
            System.out.println("No such shape found!"+'\n');
         }
      }
      
   }
}