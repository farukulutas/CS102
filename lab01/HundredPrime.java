/**
 * The program find the first 100 prime number by using instances of IntBag class.
 * @author Ahmet Faruk Uluta?
 * @version 17/02/2020
 * @version The infinite loop problem was solved using while.
 */
public class HundredPrime {
   
   public static void main( String[] args) {
      
      // constants
      
      // variables
      IntBag bag;
      int prime, num, index;
      boolean isEnd;
      
      // program code
      
      // initilialization of bag, isEnd and num
      bag = new IntBag();
      isEnd = false;
      num = 3;
      
      // adding the first prime number which is two
      bag.add(2);
      
      // creating while method which will be stop when size of bag is ended
      while ( !isEnd)
      {
         prime = 0;
         index = 0;
         if (bag.size() == 100)
         {
            isEnd = true;
         }
         else
         {
            // while method which will be stop when size of bag is ended
            while ( index < bag.size())
            {
               if ( num  % bag.get(index) == 0)
               {
                  prime++;
               }
               index = index + 1;
            }
            if (prime == 0)
            {
               bag.add(num);
            }
            num = num + 1;
         }
      }
      
      // print the first hundred of prime number
      System.out.println( bag);
   }
   
}