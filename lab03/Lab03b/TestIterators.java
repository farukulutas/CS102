import java.util.Iterator;

/**
 * A simple Iterator interface
 * @author Ahmet Faruk Ulutaþ
 * @date 09/03/2020
 */
public class TestIterators {
   public static void main( String[] args) {
      Iterator i, j;
      
      IntBag bag = new IntBag();
      
      for (int a = 0; a < 6; a++ ) {
         bag.add( a);
      }
      
      i = new IntBagIterator( bag);
      
      while ( i.hasNext() ) 
      {
         System.out.println( i.next() );
         
//         j = new IntBagIterator( bag);
         j = bag.iterator();
         
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }
   }
   
}