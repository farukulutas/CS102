package shapes;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * to hold a set of shapes
 * @author Ahmet Faruk Ulutaþ
 * @date 08/03/2020
 */
public class ShapeContainer implements Iterable
{
   // properties
   ArrayList<Shape> shapeContainer;
   
   // constructors
   public ShapeContainer() {
      shapeContainer = new ArrayList<Shape>();
   }
   
   // methods
   
   /**
    * This method create iterator object from shape container
    * @return shapeContainer.iterator() Create iterator object from shape container
    */
   public Iterator<Shape> iterator() {
      return shapeContainer.iterator();
   }
   
   /**
    * This method count the shapes which includes x and y at the same time and return the number of shapes
    * @param x Position of X
    * @param y Position of Y
    * @return numberOfShapes Number of shapes
    */
   public int selectAllAt(int x, int y) {
      int numberOfShapes = 0;
      for (int i = 0 ; i < shapeContainer.size() ; i++) {
         if (((Selectable)shapeContainer.get(i)).contains(x, y) == shapeContainer.get(i)) {
            if ((Selectable)shapeContainer.get(i) != null) {
               ((Selectable)shapeContainer.get(i)).setSelected(true);
               numberOfShapes += 1;
            }
         }
      }
      return numberOfShapes;
   }
   
   /**
    * This method returns size of the shape container
    * @return this.shapeContainer.size() number of shapes
    */
   public int size() {
      return this.shapeContainer.size();
   }
   
   /**
    * This method return the first container which includes x and y at the same time or return null
    * @param x axis position
    * @param y axis position
    * @return shapeContainer.get( i) which is the one of the shapes or null
    */
   public Shape contains( int x, int y) {
      for ( int i = 0; i < shapeContainer.size(); i++ ) {
         if ( shapeContainer.get(i).contains(x, y) != null) {
            return shapeContainer.get( i);
         }
      }
      
      return null;
   }
   
   /**
    * @param s
    * @return x axis
    */
   public void add( Shape s) {
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
      
      selectedCheck = false;
      
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