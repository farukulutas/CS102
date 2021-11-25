import java.util.Iterator; 

/**
 * A simple Iterator interface
 * @author Ahmet Faruk Ulutaş
 * @date 09/03/2020
 */
public class IntBagIterator extends IntIterator {
   
   // properties
   private IntBag aBag;
   private int index;
   
   // constructors
   public IntBagIterator( IntBag aBag ) {
      this.aBag = aBag;
      index = 0;
   }
   
   // program code
   public int nextInt() {
      if ( hasNext() ) {
      index += 1;
      
      return aBag.get( index - 1 );
      }
      else
         return -1;
   }
   
   public Integer next() {
      if ( hasNext() ) {
         int a = aBag.get( index);
         Integer number2 = new Integer( a );
         index += 1;
         return number2;
      }
      else
         return null;
   }
   
   public boolean hasNext() {
      if( aBag.size() - 1 > index ) {
         return true;
      }
      else {
         return false;  
      }
   }
}