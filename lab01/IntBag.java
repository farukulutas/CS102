import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/* Simple IntBag Class!
 * @author Ahmet Faruk Ulutaþ
 * @version 17/02/2020
 * @version The findAll method and its javadoc are added.
 */
public class IntBag {
   
   // properties
   int bag[]; // an int array called bag that will hold the values of the collection
   int valid; // that says how many of the elements of bag actually contain values in the collection.
   int maxElements;
   
   // constructors
   public IntBag() { // one that creates an empty collection (with room for up to 100 elements)
      
      maxElements = 100;
      bag = new int[maxElements];
      valid = 0;
      
   }
   
   public IntBag( int maxNumberOfElements) { // another that takes the desired maximum number of elements as a parameter
      
      maxElements = maxNumberOfElements;
      bag = new int[maxElements];
      valid = 0;
      
   }
   
   // methods
   
   /**
    * @param value New value for the collection.
    * @return true if valid is increased or return false.
    */
   public boolean add( int value) {
      
      if ( valid < maxElements ) {
         
         bag[valid] = value;
         valid++;
         return true;
      }
      return false;
      
   }
   
   /**
    * @param value New value for the collection.
    * @param i Index of an element.
    */
   public boolean add( int i, int value ) {
      
      if ( valid < maxElements && i >= 0 && i < valid ) {
         
         for ( int a = valid + 1; a > i; a-- ) {
            
            bag[ a] = bag[a - 1];
         }
         
         bag[i] = value;
         valid++;
         return true;
      }
      return false;
   }
   
   /**
    * @param i This is the index of element which will be removed.
    * @return True if element is removed or return false.
    */
   public boolean remove(int i)
  {
    if (i >=0 && i < valid)
    {
      for (int j = valid - 2 ; j >= i ; j--)
      {
        bag[j] = bag[j+1];
      }
      valid--;
      return true;
      
    }
    return false;
    
  }
   
   /**
    * @param bag[] This is the array which will be used to create new array.
    * @param i This is the index of element which will be searched.
    * @return true If the value is not in the array.
    * @return false If the value is not in the array
    */
   public static boolean contains( Integer bag[], int value) {
      
      // Creates an arrayList.
      List<Integer> arrayList = new ArrayList<Integer>( Arrays.asList(bag));
      
      if ( arrayList.contains( value) ) {
         
         return true;
      }
      else {
         
         return false;   
      }
   }
   
   /**
    * @param bag[] This is the array which will be converted to string representation.
    * @return This returns to string representation of collection.
    */
   public String toString() {
      
      String stringBag;
      stringBag = "";
      if (valid > 0)
      {
         for (int i = 0; i < valid; i++ )
         {
            stringBag = stringBag + bag[i];
            stringBag = stringBag + " ";
         }
         return stringBag;
      }
      return stringBag;
   }
   
   /**
    * @return This returns the size of the collection.
    */
   public int size() {
      
      return valid;
   }
   
   /**
    * @param i This is the index which will be found in the array.
    * @return This returns to the element of index i.
    */
   public int get( int i) {
      
      return bag[i];
   }
   
   /**
    * @param value This is the value which will be found.
    * @return This returns to the element of index i.
    */
   public String findAll( int value)
   {
      String index;
      index = "";
      for (int i = 0; i < valid; i++)
      {
         if ( bag[i] == value )
         {
            index = index + i;
            index = index + " ";
         }
      }
      
      return index;
   }
   
}